package com.yyou.tools.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class DefaultAccessValidator implements IAccessValidator {

    private int expireMinutes;

    public DefaultAccessValidator(int expireMinutes) {
        this.expireMinutes = expireMinutes;
    }

    private Date getExpireData(){
        Date expireDate = null;
        if(expireMinutes > 0){
            expireDate = new Date(System.currentTimeMillis()+60*expireMinutes);
        }
        return expireDate;
    }

    private boolean isTokenAccess(String token){
        JWT.require(Algorithm)
    }

    @Override
    public String getToken(long id,String password) {
        String idString = Long.toString(id);
        JWTCreator.Builder builder = JWT.create().withAudience(idString);
        Date expireDate = getExpireData();
        if(expireDate!=null){
            builder.withExpiresAt(expireDate);
        }
        return builder.sign(Algorithm.HMAC256(password));
    }

    @Override
    public String getAccessKey(String token) {
         return JWT.decode(token).getAudience().get(0);
    }
}
