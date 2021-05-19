package com.covidcenter.covidcenter.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 //this controller will be used for all shared functionalities of our system like login,logout
@RestController
public class GeneralController {
    @GetMapping("/api/login")
    public String sayHello(){return "hello";}
}
