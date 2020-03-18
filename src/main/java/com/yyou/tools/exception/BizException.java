package com.yyou.tools.exception;

import com.yyou.data.HttpMessage;

public class BizException extends CustomerException {
    public BizException(String message) {
        super(HttpMessage.BIZ_ERROR, message);
    }

    public BizException(Exception ex) {
        this(ex.toString());
    }
}
