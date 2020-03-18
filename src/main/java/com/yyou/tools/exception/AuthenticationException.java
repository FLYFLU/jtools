package com.yyou.tools.exception;

import com.yyou.data.HttpMessage;

public class AuthenticationException extends CustomerException {
    public AuthenticationException() {
        super(HttpMessage.NOT_Authentication, "未授权");
    }
}
