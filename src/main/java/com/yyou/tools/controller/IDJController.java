package com.yyou.tools.controller;

import com.yyou.data.HttpMessage;
import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.entity.IDjRelation;
import com.yyou.tools.entity.User;
import com.yyou.tools.service.IDjUserService;
import com.yyou.tools.service.IIdjService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Api(description = "爱党建")
@RestController
@RequestMapping("idj")
public class IDJController {

    @Autowired
    private IIdjService iIdjService;
    @Autowired
    private IDjUserService iDjUserService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public HttpMessage login(@RequestParam("name") String name,@RequestParam("password") String password){
        return iIdjService.login(name,password);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.GET)
    public IDJUser getUser(@PathVariable("id") Integer id){
        IDJUser user = iDjUserService.getUser(id);
        IDjRelation sysUser = user.getUser();
        return user;
    }
    @RequestMapping(value = "users/{id}/1",method = RequestMethod.GET)
    public int getUser1(@PathVariable("id") Integer id){
        IDJUser user = iDjUserService.getUser(id);
        return user.getId();
    }
}
