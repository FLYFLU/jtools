package com.yyou.tools.exception;

public class HttpRequestException extends CustomerException {
    public HttpRequestException(int code) {
        super(code, "http请求错误");
    }
}
