package com.covidcenter.covidcenter.service;

import java.util.List;

import com.covidcenter.covidcenter.model.Booking;
import com.covidcenter.covidcenter.model.CovidTest;
import com.covidcenter.covidcenter.model.Vaccine;

public interface UserActionService {

    List<CovidTest> fetchAll();

    List<Vaccine> fetchAllVaccines();

    int addTest(Booking test);

    int addVaccine(Booking vaccine);

    int changeTestStatus(int userID, Booking test);

    int changeVaccineStatus(int userID, Booking vaccine);
}
