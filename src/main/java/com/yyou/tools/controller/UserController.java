package com.yyou.tools.controller;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dto.user.UpdateUserDto;
import com.yyou.tools.dto.user.UserDto;
import com.yyou.tools.entity.User;
import com.yyou.tools.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "用户")
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id")long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public HttpMessage addUser(@RequestBody UserDto user){
        return userService.addUser(user);
    }

    @PostMapping("{id}")
    public HttpMessage updateUser(@PathVariable("id") long id, @RequestBody UpdateUserDto user){
        return userService.updateUser(id,user);
    }
}
