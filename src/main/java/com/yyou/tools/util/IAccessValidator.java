package com.yyou.tools.util;

public interface IAccessValidator {
    String getToken(long id,String passwrod);

    String getAccessKey(String token);
}
