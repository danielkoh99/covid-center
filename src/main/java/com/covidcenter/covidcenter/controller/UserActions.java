
package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.enums.BookingStatusCode;
import com.covidcenter.covidcenter.enums.BookingTypeCode;
import com.covidcenter.covidcenter.model.*;

import com.covidcenter.covidcenter.repository.IBookingRepo;
import com.covidcenter.covidcenter.service.UserActionService;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/actionApi")
public class UserActions {
    final String APIPATH = "/actionApi";
    @Autowired
    UserActionService userActionService;
    @Autowired
    IBookingRepo bookingRepo;

    @GetMapping(APIPATH + "/test")
    public String Test() {
        Gson gson = new Gson();
        return gson.toJson(bookingRepo.fetchAll());
    }

    @GetMapping(APIPATH + "/vaccine")
    public String Vaccine() {
        Gson gson = new Gson();
        return gson.toJson(userActionService.fetchAllVaccines());
    }

    @PostMapping(APIPATH + "/test")
    public ResponseEntity<?> CreateTest(@RequestBody String covidtest) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Booking.class, new TestDeserializer()).create();
        Booking test = gson.fromJson(covidtest, Booking.class);
        userActionService.addTest(test);
        System.out.println(test);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(APIPATH + "/vaccine")
    public ResponseEntity<?> CreateVaccine(@RequestBody String vaccine) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Booking.class, new TestDeserializer()).create();
        Booking test = gson.fromJson(vaccine,Booking.class);
        test.setBookingType_idbookingType(new BookingType(BookingTypeCode.vacccination));
        test.setBookingStatus_idbookingStatus(new BookingStatus(BookingStatusCode.vaccinated));
        userActionService.addTest(test);
        System.out.println(test);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping(APIPATH + "/vaccine")
    public ResponseEntity<?> UpdateVaccine(@RequestBody String vaccine) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Booking.class, new TestUpdateDeserializer()).create();
        Booking test = gson.fromJson(vaccine,Booking.class);

        bookingRepo.updateBooking(0,test);
        System.out.println(test);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
