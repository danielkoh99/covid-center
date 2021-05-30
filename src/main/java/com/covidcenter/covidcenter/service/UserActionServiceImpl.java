package com.covidcenter.covidcenter.service;

import java.util.List;

import com.covidcenter.covidcenter.model.CovidTest;
import com.covidcenter.covidcenter.model.Vaccine;
import com.covidcenter.covidcenter.repository.UserActionsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActionServiceImpl implements UserActionService {
    @Autowired
    UserActionsRepo userActionsRepo;

    @Override
    public List<CovidTest> fetchAll() {
        return userActionsRepo.fetchAll();
    }

    @Override
    public List<Vaccine> fetchAllVaccines() {
        return userActionsRepo.fetchAllVaccines();
    }

    @Override
    public int addTest(CovidTest test) {
        return userActionsRepo.addTest(test);
    }

    @Override
    public int addVaccine(Vaccine vaccine) {
        return userActionsRepo.addVaccine(vaccine);
    }

    @Override
    public int changeTestStatus(int userID, CovidTest test) {
        return userActionsRepo.changeTestStatus(userID, test);
    }

    @Override
    public int changeVaccineStatus(int userID, Vaccine vaccine) {
        return userActionsRepo.changeVaccineStatus(userID, vaccine);
    }

}
