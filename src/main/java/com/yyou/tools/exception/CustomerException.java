package com.yyou.tools.exception;

public class CustomerException extends RuntimeException {


    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CustomerException(int code,String message){
        super(message);
        this.code = code;
    }
}
