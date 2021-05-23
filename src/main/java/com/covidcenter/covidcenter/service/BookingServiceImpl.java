package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.Booking;
import com.covidcenter.covidcenter.repository.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {
    @Autowired
    IBookingRepo bookingRepo;
    @Override
    public List<Booking> fetchAll() {
        return bookingRepo.fetchAll();
    }

    @Override
    public List<Booking> fetchAll(int userID, String token) {
        return bookingRepo.fetchAll(userID, token);
    }

    @Override
    public int createBooking(int userID, Booking booking) {
        return bookingRepo.createBooking(userID, booking);
    }

    @Override
    public int updateBooking(int userID, Booking booking) {
        return bookingRepo.updateBooking(userID, booking);
    }

    @Override
    public Booking getBooking(int bookingID) {
        return bookingRepo.getBooking(bookingID);
    }

    @Override
    public int deleteBooking(int bookingID) {
        return bookingRepo.deleteBooking(bookingID);
    }
}
