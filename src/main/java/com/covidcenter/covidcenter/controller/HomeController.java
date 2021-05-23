package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.CovidcenterApplication;
import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.covidcenter.covidcenter.enums.BookingTypeCode;
import com.covidcenter.covidcenter.model.Booking;
import com.covidcenter.covidcenter.model.BookingStatus;
import com.covidcenter.covidcenter.model.BookingType;
import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.service.IBookingService;
import com.covidcenter.covidcenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IUserService userService;
    @Autowired
    IBookingService bookingService;

    @GetMapping("/")
    public String Home() {
        bookingService.createBooking(1,new Booking(1,"d","f", new BookingStatus(BookingStatusCode.pending),new BookingType(BookingTypeCode.test),1));

        return "Index";
    }

    @GetMapping("/logged")
    public String LoggedIn() {
        return "admin";
    }


}
