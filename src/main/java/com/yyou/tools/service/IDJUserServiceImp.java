package com.yyou.tools.service;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dto.idj.AddIdjUserDto;
import com.yyou.tools.dto.idj.UpdateIdjUserDto;
import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.dao.IDJUserDao;
import com.yyou.tools.mapper.IdjUserMapper;
import com.yyou.tools.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IDJUserServiceImp implements IDjUserService {
    @Autowired
    private IDJUserDao idjUserDao;
    @Autowired
    private IdjUserMapper idjUserMapper;
    @Autowired
    private IdGenerator idGenerator;
    @Override
    public IDJUser getUser(long id) {
        return idjUserDao.getById(id);
    }

    @Override
    public List<IDJUser> getAll() {
        return  idjUserDao.getAll();
    }

    @Override
    public HttpMessage addIdjUser(AddIdjUserDto addIdjUserDto) {
        IDJUser idjUser = idjUserMapper.addDto2Entity(addIdjUserDto);
        idjUser.setId(idGenerator.getId());
        int effectCount = idjUserDao.addIdjUser(idjUser);
        return effectCount>0?
                HttpMessage.OK:
                new HttpMessage(-1,"新增失败");
    }

    @Override
    public HttpMessage updateIdjUser(long id, UpdateIdjUserDto idjUserDto) {
        IDJUser idjUser = idjUserMapper.updateDto2Entity(idjUserDto);
        idjUser.setId(id);
        int effectCount = updateIdjUserInternal(idjUser);
        return effectCount>0?
                HttpMessage.OK:
                new HttpMessage(-1,"更新失败");
    }

    @Transactional
    int updateIdjUserInternal(IDJUser idjUser){
        IDJUser dbIdjUser =  idjUserDao.getById(idjUser.getId());
        if(dbIdjUser == null){
            return 0;
        }else{
            return idjUserDao.updateIdjUser(idjUser);
        }
    }

}
