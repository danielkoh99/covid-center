package com.covidcenter.covidcenter.enums;

public enum bookingStatusCode{
    test(1),vaccination(2);

    private int bookingStatusCode;
    bookingStatusCode(int code){
        this.bookingStatusCode=code;
    }

    public int getCode(){
        return bookingStatusCode;
    }
}
