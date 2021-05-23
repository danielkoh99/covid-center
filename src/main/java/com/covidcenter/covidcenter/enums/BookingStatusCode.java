package com.covidcenter.covidcenter.enums;

public enum BookingStatusCode {
    pending(1), positive(2), negative(3), vaccinated(4);
    private int bookingStatusCode;

    BookingStatusCode(int code) {
        this.bookingStatusCode = code;
    }
    public static BookingStatusCode getCodeByNumber(int number) {
        BookingStatusCode code = null;
        switch (number) {
            case 1:
                code = BookingStatusCode.pending;
                break;
            case 2:
                code = BookingStatusCode.positive;
                break;
            case 3:
                code = BookingStatusCode.negative;
                break;
            case 4:
                code = BookingStatusCode.vaccinated;
                break;
        }
        return code;
    }
    public int getCode() {
        return bookingStatusCode;
    }
}



