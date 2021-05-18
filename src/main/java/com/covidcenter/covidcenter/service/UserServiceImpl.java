package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public List<User> fetchAll() {
        return userRepo.fetchAll();
    }

    @Override
    public int addUser(User u) {
        return userRepo.addUser(u);
    }

    @Override
    public int updateUser(User u) { return userRepo.updateUser(u); }

    @Override
    public User getUser(int userID) {
        return userRepo.getUser(userID);
    }

    @Override
    public User getUser(String email) {
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
