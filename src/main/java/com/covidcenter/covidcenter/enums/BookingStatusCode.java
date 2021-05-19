package com.covidcenter.covidcenter.enums;

public enum BookingStatusCode {
    test(1), vaccination(2);

    private int bookingStatusCode;

    BookingStatusCode(int code) {
        this.bookingStatusCode = code;
    }

    public int getCode() {
        return bookingStatusCode;
    }
}
