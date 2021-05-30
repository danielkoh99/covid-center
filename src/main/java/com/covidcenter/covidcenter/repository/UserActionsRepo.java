package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.CovidTest;
import com.covidcenter.covidcenter.model.Vaccine;

import java.util.List;

public interface UserActionsRepo {
    List<CovidTest> fetchAll();

    List<Vaccine> fetchAllVaccines();

    int addTest(CovidTest test);

    int addVaccine(Vaccine vaccine);

    int changeVaccineStatus(int userID, Vaccine vaccine);

    int changeTestStatus(int userID, CovidTest test);

}
