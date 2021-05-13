package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.user;
import org.apache.tomcat.jni.User;

import java.util.List;

public interface IUserRepo {
    List<user> fetchAll();
    User addUser(user u);
}
