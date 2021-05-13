package com.covidcenter.covidcenter.enums;

public enum userTypeCode {
    administrator(1), secretary(2),user(3);
    private int code;
    userTypeCode(int code){ this.code=code; }

    public int getCode(){
        return code;
    }
}
