package com.yyou.tools.controller;

import com.yyou.data.CustomResponse;
import com.yyou.tools.annotations.AllowToken;
import com.yyou.tools.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping()
    @AllowToken(required = false)
    public CustomResponse getToken(long id,String password){
        String token = tokenService.getToken(id,password);
        return CustomResponse.http200(token);
    }
}
