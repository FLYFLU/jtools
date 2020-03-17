package com.yyou.tools.controller;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dto.idj.AddIdjUserDto;
import com.yyou.tools.dto.idj.UpdateIdjUserDto;
import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.service.IDjUserService;
import com.yyou.tools.service.IIdjService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public IDJUser getUser(@PathVariable("id") long id){
        IDJUser user = iDjUserService.getUser(id);
//        IDjRelation sysUser = user.getUser();
        return user;
    }

    @PostMapping(value = "users")
    public HttpMessage addIdjUser(@RequestBody AddIdjUserDto dto){
        HttpMessage message = iDjUserService.addIdjUser(dto);
        return message;
    }

    @PostMapping(value = "users/{id}")
    public HttpMessage updateIdjUser(@PathVariable("id") long id,
                                     @RequestBody UpdateIdjUserDto dto){
        HttpMessage message = iDjUserService.updateIdjUser(id,dto);
        return message;
    }
}
