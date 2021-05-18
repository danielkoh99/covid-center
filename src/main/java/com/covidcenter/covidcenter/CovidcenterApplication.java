package com.covidcenter.covidcenter;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.model.UserType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidcenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(CovidcenterApplication.class, args);
    }

}
