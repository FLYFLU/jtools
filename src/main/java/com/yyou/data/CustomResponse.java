package com.yyou.data;

public class CustomResponse<T extends Object> {
    private int code;
    private T payload;

    public int getCode() {
        return code;
    }

    public T getPayload() {
        return payload;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public CustomResponse(int code, T payload) {
        this.code = code;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "code=" + code +
                ", payload=" + payload +
                '}';
    }

    public static <T extends Object> CustomResponse<T> http200(T message) {
        return new CustomResponse<>(HttpMessage.OK, message);
    }
    public static CustomResponse<String> http401(String message) {
        return new CustomResponse<>(HttpMessage.NOT_Authentication, message);
    }
    public static CustomResponse<String> http404(String message) {
        return new CustomResponse<>(HttpMessage.NOT_FOUND, message);
    }

    public static CustomResponse<String> http500(String message) {
        return new CustomResponse<>(HttpMessage.INNER_EXCEPTION, message);
    }

    public static CustomResponse<String> http500(Exception ex) {
        return new CustomResponse<>(HttpMessage.INNER_EXCEPTION, ex.toString());
    }

    public static CustomResponse<String> http400(String message) {
        return new CustomResponse<>(HttpMessage.BIZ_ERROR, message);
    }

}
