package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.*;
import com.covidcenter.covidcenter.service.IBookingService;
import com.covidcenter.covidcenter.service.IInternalService;
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
    @Autowired
    IInternalService internalService;

    @GetMapping(APIPATH)
    public String Booking(@RequestHeader HttpHeaders headers) {
        Gson gson = new Gson();
        try {
            Integer user= Integer.valueOf(headers.getFirst("userID"));
            String token=headers.getFirst("token");
            Boolean vf= internalService.VerifyToken(user, token);
            if (vf){
                return gson.toJson(bookingService.fetchAll(user,""));
            }
            else {
                return "logout";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());

            return "error";
        }
    }

    @GetMapping(APIPATH+"/{id}")
    public String Booking (@PathVariable(value = "id") String id, @RequestHeader HttpHeaders headers) {
        Gson gson = new Gson();
        try {
            Integer user= Integer.valueOf(headers.getFirst("userID"));
            String token=headers.getFirst("token");
            Boolean vf= internalService.VerifyToken(user, token);
            if (vf){
                return gson.toJson(bookingService.getBooking(Integer.parseInt(id)));
            }
            else {
                return "logout";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }

    }
    @PostMapping(APIPATH)
    public String CreateBooking (@RequestBody String body, @RequestHeader HttpHeaders headers) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Booking.class, new BookingDeserializer()).create();

        ArrayList<ValidationError> validationErrors = new ArrayList<>();
        try {
            Booking booking = gson.fromJson(body,Booking.class);
            booking.setUser_id_user(Integer.valueOf(headers.getFirst("userID")));
            String token=headers.getFirst("token");
           Boolean vf= internalService.VerifyToken(booking.getUser_id_user(), token);
            if (vf){
                bookingService.createBooking(0,booking);
            }
            else {
                return "logout";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "error";

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
       Integer user= Integer.valueOf(headers.getFirst("userID"));
        Boolean vf= internalService.VerifyToken(user, token);
        if (vf){
            bookingService.deleteBooking(booking.idbookings);
        }
        else {
            return "logout";
        }
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }

    return gson.toJson(bookingService.fetchAll(Integer.valueOf(headers.getFirst("userID")),""));

}

    @PutMapping(APIPATH)
    public String UpdateBooking (@RequestBody String body, @RequestHeader HttpHeaders headers) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Booking.class, new BookingDeserializer()).create();

        ArrayList<ValidationError> validationErrors = new ArrayList<>();
        try {
            Booking booking = gson.fromJson(body,Booking.class);
            String token=headers.getFirst("token");
            Integer user= Integer.valueOf(headers.getFirst("userID"));
            Boolean vf= internalService.VerifyToken(user, token);
            if (vf){
                bookingService.updateBooking(booking.getUser_id_user(), booking);
            }
            else {
                return "logout";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return gson.toJson(bookingService.fetchAll(Integer.valueOf(headers.getFirst("userID")),""));
    }

}
