package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.user;

import java.util.List;

public interface IUserRepo {
    List<user> fetchAll();

    int addUser(user u);
    int updateUser(user u);
    user getUser(int userID);
    user getUser(String email);
    String login(int userID) throws Exception;
    Boolean logout(int userID);
}
