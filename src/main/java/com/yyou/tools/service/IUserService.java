package com.yyou.tools.service;

import com.github.pagehelper.PageInfo;
import com.yyou.data.HttpMessage;
import com.yyou.data.PagedQuery;
import com.yyou.tools.dto.user.QueryUserDto;
import com.yyou.tools.dto.user.UpdateUserDto;
import com.yyou.tools.dto.user.UserDto;
import com.yyou.tools.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    User getUserById(long uuid);
    void addUser(UserDto user);
    void updateUser(long id,UpdateUserDto user);
    PageInfo<User> getUserByPage(QueryUserDto userDto, PagedQuery pagedQuery);
}
