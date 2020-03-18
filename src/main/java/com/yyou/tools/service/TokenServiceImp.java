package com.yyou.tools.service;

import com.yyou.tools.util.IAccessValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImp implements TokenService {
    @Autowired
    private IAccessValidator accessValidator;

    @Override
    public String getToken(long id, String password) {
        return accessValidator.getToken(id,password);
    }

}
