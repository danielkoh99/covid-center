package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InternalRepoImpl implements IInternalRepo{
    @Autowired
    JdbcTemplate template;
    @Autowired
    IUserService userService;
    @Override
    public Boolean VerifyToken(int userID, String token) {
       User user= userService.getUser(userID);
       if (!token.equals(user.getToken())){
           return false;
       }
       return true;
    }

    @Override
    public Boolean VerifyAccess(User user) {
        return null;
    }
}
