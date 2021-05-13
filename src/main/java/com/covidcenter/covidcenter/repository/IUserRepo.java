package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.user;

import java.util.List;

public interface IUserRepo {
    List<user> fetchAll();

    int addUser(user u);
}
