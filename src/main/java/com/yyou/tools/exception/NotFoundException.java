package com.yyou.tools.exception;

import com.yyou.data.HttpMessage;

public class NotFoundException extends CustomerException {

    public NotFoundException(String message) {
        super(HttpMessage.NOT_FOUND, message);
    }
}
