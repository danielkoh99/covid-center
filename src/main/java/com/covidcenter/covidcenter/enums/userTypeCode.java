package com.covidcenter.covidcenter.enums;

public enum UserTypeCode {
    administrator(1), secretary(2), user(3);

    private int code;

    private UserTypeCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
