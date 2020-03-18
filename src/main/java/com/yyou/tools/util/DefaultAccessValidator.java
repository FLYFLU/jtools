package com.yyou.tools.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class DefaultAccessValidator implements IAccessValidator {

    @Override
    public String getToken(long id,String password) {
        String idString = Long.toString(id);
        Date expireDate = new Date(System.currentTimeMillis()+60*30);
        return JWT.create().withExpiresAt(expireDate).withAudience(idString).sign(Algorithm.HMAC256(password));
    }

    @Override
    public String getAccessKey(String token) {
         return JWT.decode(token).getAudience().get(0);
    }
}
