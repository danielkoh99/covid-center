
package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.model.CovidTest;

import com.covidcenter.covidcenter.service.UserActionService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/actionApi")
public class UserActions {
    final String APIPATH = "/actionApi";
    @Autowired
    UserActionService userActionService;

    @GetMapping(APIPATH + "/test")
    public String Test() {
        Gson gson = new Gson();
        return gson.toJson(userActionService.fetchAll());
    }

    @GetMapping(APIPATH + "/vaccine")
    public String Vaccine() {
        Gson gson = new Gson();
        return gson.toJson(userActionService.fetchAllVaccines());
    }

    @PostMapping(APIPATH + "/test")
    public ResponseEntity<?> CreateTest(@RequestBody String covidtest) {
        Gson gson = new Gson();
        CovidTest test = gson.fromJson(covidtest, CovidTest.class);
        userActionService.addTest(test);
        System.out.println(test);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(APIPATH + "/vaccine")
    public ResponseEntity<?> CreateVaccine(@RequestBody String vaccine) {
        Gson gson = new Gson();
        CovidTest test = gson.fromJson(vaccine, CovidTest.class);
        userActionService.addTest(test);
        System.out.println(test);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
