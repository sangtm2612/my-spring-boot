package com.example.springbootsample.common;

import lombok.Data;

@Data
public class BaseResponse <T> {
    private int code;
    private String message;
    private T data;

    public BaseResponse(T data) {
        this.data = data;
        responseSuccess();
    }

    public void responseSuccess() {
        this.code = 200;
        this.message = "Success";
    }

}
