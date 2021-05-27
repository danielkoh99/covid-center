package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.User;

import java.util.List;

public interface IUserRepo {
    List<User> fetchAll();

    int toggle(int userID, UserTypeCode type);

    int addUser(User u);

    int updateUser(User u);

    User getUser(int userID);

    User getUser(String email);

    String login(int userID) throws Exception;

    Boolean logout(int userID);

}
