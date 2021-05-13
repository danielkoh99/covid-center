package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.user;
import com.covidcenter.covidcenter.repository.IUserRepo;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public List<user> fetchAll() {
        return userRepo.fetchAll();
    }

    @Override
    public int addUser(user u) {
        return userRepo.addUser(u);
    }
}
