package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.user;
import com.covidcenter.covidcenter.repository.IUserRepo;
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

    @Override
    public int updateUser(user u) { return userRepo.updateUser(u); }

    @Override
    public user getUser(int userID) {
        return userRepo.getUser(userID);
    }

    @Override
    public user getUser(String email) {
        return userRepo.getUser(email);
    }

    @Override
    public String login(int userID) throws Exception {
        return userRepo.login(userID);
    }

    @Override
    public Boolean logout(int userID) {
        return userRepo.logout(userID);
    }


}
