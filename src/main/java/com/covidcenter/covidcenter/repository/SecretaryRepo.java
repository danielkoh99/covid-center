package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.Secretary;

import java.util.List;

public interface SecretaryRepo {
    List<Secretary> fetchAll();

    int add(Secretary u);

    int updateUser(Secretary u);

    int changeTestResult(int cprNumber);

    int addVaccine(int cprNumber);

    Secretary getUser(int userID);

    Secretary getUser(String email);

    String login(int userID) throws Exception;

    Boolean logout(int userID);
}
