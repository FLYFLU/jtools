package com.yyou.tools.controller;

import com.yyou.tools.entity.User;
import com.yyou.tools.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Api(description = "用户")
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id")long uuid){
        return userService.getUserById(uuid);
    }
}
