package com.yyou.tools.service;

import com.yyou.tools.entity.User;

import java.util.UUID;

public interface IUserService {
    User getUserById(String uuid);
}
