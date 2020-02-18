package com.yyou.data;

public class HttpException extends Exception {
    private int stateCode;
    public HttpException(int stateCode){
        this.stateCode = stateCode;
    }
}
