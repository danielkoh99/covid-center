package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.Booking;
import com.covidcenter.covidcenter.model.CovidTest;
import com.covidcenter.covidcenter.model.Vaccine;

import java.util.List;

public interface UserActionsRepo {
    List<CovidTest> fetchAll();

    List<Vaccine> fetchAllVaccines();

    int addTest(Booking test);

    int addVaccine(Booking vaccine);

    int changeVaccineStatus(int userID, Booking vaccine);

    int changeTestStatus(int userID, Booking test);

}
