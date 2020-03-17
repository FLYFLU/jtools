package com.yyou.tools.service;

import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.dao.IDJUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDJUserServiceImp implements IDjUserService {
    @Autowired
    private IDJUserDao idjUserDao;
    @Override
    public IDJUser getUser(int id) {
        return idjUserDao.getById(id);
    }

    @Override
    public List<IDJUser> getAll() {
        return  idjUserDao.getAll();
    }

}
