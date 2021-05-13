package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.bookingStatusCode;

public class bookingStatus {
    int idbookingStatus;
    bookingStatusCode bookingStatus;

    public bookingStatus(){

    }

    public bookingStatus(int idbookingStatus, bookingStatusCode bookingStatus) {
        this.idbookingStatus = idbookingStatus;
        this.bookingStatus = bookingStatus;
    }

    public int getId() {
        return idbookingStatus;
    }

    public void setStatusID(int id) {
        this.idbookingStatus = id;
    }

    public bookingStatusCode getStatus() {
        return bookingStatus;
    }

    public void setStatus(bookingStatusCode bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


}
