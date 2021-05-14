package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.enums.userTypeCode;
import com.covidcenter.covidcenter.model.user;
import com.covidcenter.covidcenter.model.userType;
import com.covidcenter.covidcenter.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
public class UserApi {
    final String APIPATH="api";
    @Autowired
    IUserService userService;
    @GetMapping(APIPATH+"/user")
    public String Home(Model model){
      //  user testuser= new user(1,"45672345","George","Brown",34,new userType(userTypeCode.user),"george","12","hhh","");
        Gson gson =new Gson();
        return gson.toJson(userService.fetchAll());
    }
    @PostMapping(APIPATH+"/user")
    public ResponseEntity<?> Create(@RequestBody String u, @RequestHeader HttpHeaders headers) {
        Gson gson =new Gson();

        user user = gson.fromJson(u, user.class);
        user.setUserType(new userType(userTypeCode.user));
        //u= new user(1,"45672345","George","Brown",34,new userType(userTypeCode.user),"george","12","hhh","");
        int result = userService.addUser(user);
        if (result > 0) {
            return new ResponseEntity<>(null, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
/*
idUser:9
        cprNumber:1234
        name:tester
        surname:testurnem
        Age:12
        userType:3
        email:cosmov
        loginTime:blob
        password:1234
        token:123*/
