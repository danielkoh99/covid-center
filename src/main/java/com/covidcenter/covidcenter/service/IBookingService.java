package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.Booking;
import com.covidcenter.covidcenter.model.User;

import java.awt.print.Book;
import java.util.List;

public interface IBookingService {
    List<Booking> fetchAll();
    List<Booking> fetchAll(int userID, String token);

    int createBooking(int userID, Booking booking);
    int updateBooking(int userID, Booking booking);
    Booking getBooking(int bookingID);
    int deleteBooking(int bookingID);

}
