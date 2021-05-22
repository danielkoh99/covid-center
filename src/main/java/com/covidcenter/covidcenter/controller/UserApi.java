package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.ValidationError;
import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.model.UserType;
import com.covidcenter.covidcenter.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/api/user")
public class UserApi {
    final String APIPATH = "/api/user";
    @Autowired
    IUserService userService;

    @GetMapping(APIPATH)
    public String Home(Model model) {
        // user testuser= new user(1,"45672345","George","Brown",34,new
        // userType(userTypeCode.user),"george","12","hhh","");
        Gson gson = new Gson();
        return gson.toJson(userService.fetchAll());
    }

    @PostMapping(APIPATH)
    public ResponseEntity<?> Create(@RequestBody String u, @RequestHeader HttpHeaders headers) {
        Gson gson = new Gson();
        ArrayList<ValidationError> validationErrors = new ArrayList<>();
        try {
            User user = gson.fromJson(u, User.class);
            user.setUserType(new UserType(UserTypeCode.user));
            // u= new user(1,"45672345","George","Brown",34,new
            // userType(userTypeCode.user),"george","12","hhh","");
            validationErrors = user.userValid();
            if (validationErrors.size() == 0) {
                int result = userService.addUser(user);
                if (result > 0) {
                    return new ResponseEntity<>(null, HttpStatus.OK);

                } else {
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity<>(gson.toJson(validationErrors), HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            validationErrors.add(new ValidationError("Exception", e.getMessage()));
            return new ResponseEntity<>(gson.toJson(validationErrors), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(APIPATH + "/login")
    //for testing purposes email= email@email.com password: test123
    public ResponseEntity<?> Login(@RequestBody String u) {
        Gson gson = new Gson();
        ArrayList<ValidationError> validationErrors = new ArrayList<>();
        try {
            User user = gson.fromJson(u, User.class);
            user.setUserType(new UserType(UserTypeCode.user));
            // u= new user(1,"45672345","George","Brown",34,new
            // userType(userTypeCode.user),"george","12","hhh","");

            User userR = userService.getUser(user.getEmail()); // Gets the user by email
            if (user.getHashedPassword().equals(userR.getPassword())) { // comparing the password with the
                                                                        // hashedpassword
                // login
                String loginToken = userService.login(userR.getIdUser()); // returns String token
                userR.setToken(loginToken);
                userR.setPassword("");
                return new ResponseEntity<>(gson.toJson(userR), HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Incorrect email or password", HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            e.printStackTrace();
            validationErrors.add(new ValidationError("Exception", e.getMessage()));
            return new ResponseEntity<>(gson.toJson(validationErrors), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(APIPATH + "/logout")
    public ResponseEntity<?> Logout(@RequestBody String u) {
        Gson gson = new Gson();
        ArrayList<ValidationError> validationErrors = new ArrayList<>();
        try {
            User user = gson.fromJson(u, User.class);
            userService.logout(user.getIdUser());
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            validationErrors.add(new ValidationError("Exception", e.getMessage()));
            return new ResponseEntity<>(gson.toJson(validationErrors), HttpStatus.BAD_REQUEST);
        }
    }
}
/*
 * idUser:9 cprNumber:1234 name:tester surname:testurnem Age:12 userType:3
 * email:cosmov loginTime:blob password:1234 token:123
 */
