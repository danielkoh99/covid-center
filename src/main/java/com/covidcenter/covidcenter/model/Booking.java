package com.covidcenter.covidcenter.model;


import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.covidcenter.covidcenter.enums.BookingTypeCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Booking {

    int idbookings;
    int user_id_user;
    String time;
    String endTime;

    BookingStatus bookingStatus_idbookingStatus;
    BookingType bookingType_idbookingType;
    public Booking(){

    }

    public Booking(int idbookings, String time, String endTime, BookingStatus bookingStatus_idbookingStatus, BookingType bookingType_idbookingType, int user_id_user) {
        this.idbookings = idbookings;
        this.time = time;
        this.endTime = endTime;
        this.bookingStatus_idbookingStatus = bookingStatus_idbookingStatus;
        this.bookingType_idbookingType = bookingType_idbookingType;
        this.user_id_user = user_id_user;
    }

    public void setIdbookings(int idbookings) {
        this.idbookings = idbookings;
    }

    public void setUser_id_user(int user_id_user) {
        this.user_id_user = user_id_user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setBookingStatus_idbookingStatus(BookingStatus bookingStatus_idbookingStatus) {
        this.bookingStatus_idbookingStatus = bookingStatus_idbookingStatus;
    }

    public void setBookingType_idbookingType(BookingType bookingType_idbookingType) {
        this.bookingType_idbookingType = bookingType_idbookingType;
    }

    public int getIdbookings() {
        return idbookings;
    }

    public String getTime() {
        return time;
    }

    public String getEndTime() {
        return endTime;
    }

    public BookingStatus getBookingStatus_idbookingStatus() {
        return bookingStatus_idbookingStatus;
    }

    public  BookingType getBookingType_idbookingType() {
        return bookingType_idbookingType;
    }

    public int getUser_id_user() {
        return user_id_user;
    }
}
