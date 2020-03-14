package com.yyou.tools.service;

import com.yyou.tools.entity.User;
import com.yyou.tools.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long uuid) {
        User user = userMapper.getUserById(uuid);
        return user;
    }
}
