package com.covidcenter.covidcenter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
