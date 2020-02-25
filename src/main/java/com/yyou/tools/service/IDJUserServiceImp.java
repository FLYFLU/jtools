package com.yyou.tools.service;

import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.mapper.IDJUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDJUserServiceImp implements IDjUserService {
    @Autowired
    private IDJUserMapper idjUserMapper;
    @Override
    public IDJUser getUser(int id) {
        return idjUserMapper.getById(id);
    }

    @Override
    public List<IDJUser> getAll() {
        return  idjUserMapper.getAll();
    }

}