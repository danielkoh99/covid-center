package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.enums.userTypeCode;
import com.covidcenter.covidcenter.model.user;
import com.covidcenter.covidcenter.model.userType;
import com.covidcenter.covidcenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
 @Autowired
    IUserService userService;
@GetMapping("/")
    public String Home(Model model){
    user testuser= new user(1,"45672345","George","Brown",34,new userType(userTypeCode.user),"george","12","hhh","");
    userService.addUser(testuser);
    return "Index";
    }

}
