package com.yy.hospital.controller;


//可用自定义异常取代这个类
public class CustomerErrorType {
    private String errorMessage;

    public CustomerErrorType() {

    }
    public CustomerErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
