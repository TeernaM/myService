package com.example.myService.entity;

public class CodeResponse {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CodeResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
