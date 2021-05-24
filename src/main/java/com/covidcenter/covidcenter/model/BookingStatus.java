package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.covidcenter.covidcenter.enums.UserTypeCode;

public class BookingStatus {
    int idbookingStatus;
    BookingStatusCode bookingStatus;

    public BookingStatus() {

    }
    public BookingStatus(BookingStatusCode bookingStatus) {

        idbookingStatus=bookingStatus.getCode();
        this.bookingStatus = bookingStatus;
    }
    public BookingStatus(int bookingStatusCode){
        this.bookingStatus=BookingStatusCode.getCodeByNumber(bookingStatusCode);
        idbookingStatus=bookingStatusCode;
    }

    public int getId() {
        return idbookingStatus;
    }

    public void setStatusID(int id) {
        this.idbookingStatus = id;
    }

    public BookingStatusCode getStatus() {
        return bookingStatus;
    }

    public void setStatus(BookingStatusCode bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
