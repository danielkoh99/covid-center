package com.covidcenter.covidcenter;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.model.UserType;
import com.covidcenter.covidcenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class CovidcenterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CovidcenterApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("Startup...");
        return;
    }
}
