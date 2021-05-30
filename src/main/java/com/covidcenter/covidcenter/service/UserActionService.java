package com.covidcenter.covidcenter.service;

import java.util.List;

import com.covidcenter.covidcenter.model.CovidTest;
import com.covidcenter.covidcenter.model.Vaccine;

public interface UserActionService {

    List<CovidTest> fetchAll();

    List<Vaccine> fetchAllVaccines();

    int addTest(CovidTest test);

    int addVaccine(Vaccine vaccine);

    int changeTestStatus(int userID, CovidTest test);

    int changeVaccineStatus(int userID, Vaccine vaccine);
}
