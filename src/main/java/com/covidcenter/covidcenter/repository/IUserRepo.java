package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.User;

import java.util.List;

public interface IUserRepo {
    List<User> fetchAll();

    int addUser(User u);

    int updateUser(User u);

    User getUser(int userID);

    User getUser(String email);

    String login(int userID) throws Exception;

    Boolean logout(int userID);
}
