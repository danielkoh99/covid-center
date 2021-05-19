package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String Home() {
        return "Index";
    }


}
