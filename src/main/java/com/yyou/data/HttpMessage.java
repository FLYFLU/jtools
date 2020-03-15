package com.yyou.data;

public class HttpMessage {

    public static final int OKNo = 0;

    public static final  HttpMessage OK = new HttpMessage(200,"");
    public static final  HttpMessage NOT_FOUND = new HttpMessage(404,"没有找到");
//    public static final  HttpMessage EXCEPTION = new HttpMessage(-1,"");
    private int errorno;
    private String errorMessage;

    public HttpMessage(int errorno, String errorMessage) {
        super();
        this.errorno = errorno;
        this.errorMessage = errorMessage;
    }
    public HttpMessage(int errorno, Exception ex) {
        super();
        this.errorno = errorno;
        this.errorMessage = ex.toString();
    }

    public int getErrorno() {
        return errorno;
    }

    public void setErrorno(int errorno) {
        this.errorno = errorno;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "HttpMessage{" +
                "errorno=" + errorno +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
