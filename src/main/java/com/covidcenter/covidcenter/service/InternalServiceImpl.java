package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.repository.IInternalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalServiceImpl implements IInternalService {
    @Autowired
    IInternalRepo internalRepo;
    @Override
    public Boolean VerifyToken(int userID, String token) {
        return internalRepo.VerifyToken(userID,token);
    }

    @Override
    public Boolean VerifyAccess(User user) {
       return internalRepo.VerifyAccess(user);
    }
}
