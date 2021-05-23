package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.*;
import com.covidcenter.covidcenter.service.IBookingService;
import com.covidcenter.covidcenter.service.IUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/api/booking")
public class BookingApi {
    final String APIPATH = "/api/booking";
    @Autowired
    IBookingService bookingService;

    @GetMapping(APIPATH)
    public String Booking(Model model) {
        Gson gson = new Gson();
        return gson.toJson(bookingService.fetchAll());
    }

    @GetMapping(APIPATH+"/{id}")
    public String Booking (@PathVariable(value = "id") String id) {
        Gson gson = new Gson();
        return gson.toJson(bookingService.fetchAll(Integer.parseInt(id),""));
    }
    @PostMapping(APIPATH)
    public String CreateBooking (@RequestBody String body, @RequestHeader HttpHeaders headers) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Booking.class, new BookingDeserializer()).create();

        ArrayList<ValidationError> validationErrors = new ArrayList<>();
        try {
            Booking booking = gson.fromJson(body,Booking.class);
            booking.setUser_id_user(Integer.valueOf(headers.getFirst("userID")));
            String token=headers.getFirst("token");
            bookingService.createBooking(0,booking);
            String tok4en=headers.getFirst("token");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return gson.toJson(bookingService.fetchAll(Integer.valueOf(headers.getFirst("userID")),""));
    }
@DeleteMapping(APIPATH)
    public String DeleteBooking(@RequestBody String body, @RequestHeader HttpHeaders headers){
    Gson gson = new Gson();

    ArrayList<ValidationError> validationErrors = new ArrayList<>();
    try {
        DeleteBooking booking = gson.fromJson(body,DeleteBooking.class);
        String token=headers.getFirst("token");
        bookingService.deleteBooking(booking.idbookings);
        String tok4en=headers.getFirst("token");
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }

    return gson.toJson(bookingService.fetchAll(Integer.valueOf(headers.getFirst("userID")),""));

}
}
