package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.user;
import org.apache.tomcat.jni.User;

import java.util.List;

public interface IUserService {
    List<user> fetchAll();
    int addUser(user u);
}
