package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.BookingStatusCode;

public class BookingStatus {
    int idbookingStatus;
    BookingStatusCode bookingStatus;

    public BookingStatus() {

    }

    public BookingStatus(int idbookingStatus, BookingStatusCode bookingStatus) {
        this.idbookingStatus = idbookingStatus;
        this.bookingStatus = bookingStatus;
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
