package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.Booking;

import java.util.List;

public interface IBookingRepo {
    List<Booking> fetchAll();

    List<Booking> fetchAll(int userID, String token);

    int createBooking(int userID, Booking booking);

    int updateBooking(int userID, Booking booking);

    Booking getBooking(int bookingID);

    int deleteBooking(int bookingID);
}
