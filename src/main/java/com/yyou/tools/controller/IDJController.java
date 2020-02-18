package com.yyou.tools.controller;

import com.yyou.data.HttpMessage;
import com.yyou.tools.service.IIdjService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "爱党建")
@RestController
@RequestMapping("idj")
public class IDJController {

    @Autowired
    private IIdjService iIdjService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public HttpMessage login(@RequestParam("name") String name,@RequestParam("password") String password){
        return iIdjService.login(name,password);
    }
}
