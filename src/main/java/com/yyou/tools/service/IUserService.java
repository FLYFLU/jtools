package com.yyou.tools.service;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dto.user.UpdateUserDto;
import com.yyou.tools.dto.user.UserDto;
import com.yyou.tools.entity.User;

public interface IUserService {
    User getUserById(long uuid);
    HttpMessage addUser(UserDto user);
    HttpMessage updateUser(long id,UpdateUserDto user);
}
