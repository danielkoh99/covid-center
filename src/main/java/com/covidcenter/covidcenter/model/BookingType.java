package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.BookingTypeCode;
import com.covidcenter.covidcenter.enums.UserTypeCode;

public class BookingType {
    BookingTypeCode type;
    int idbookingType;
    public BookingTypeCode getType(){ return type;}

    public int getIdbookingType() {
        return idbookingType;
    }

    public BookingType(BookingTypeCode type) {
        idbookingType=type.getCode();
        this.type=type;
    }
    public BookingType(int typeIndex) {
        this.type=BookingTypeCode.getCodeByNumber(typeIndex);;
        idbookingType=type.getCode();
    }
}