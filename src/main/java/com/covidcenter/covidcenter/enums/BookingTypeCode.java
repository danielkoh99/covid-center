package com.covidcenter.covidcenter.enums;

public enum BookingTypeCode {
    test(1), vacccination(2);
    private int code;
    private BookingTypeCode(int code){this.code=code;}
    public int getCode() {
        return code;
    }

    public static BookingTypeCode getCodeByNumber(int number){
        BookingTypeCode code=null;
        switch (number){
            case 1:
                code= BookingTypeCode.test;
                break;

            case 2:
                code= BookingTypeCode.vacccination;
                break;
        }
        return code;
    }
}

