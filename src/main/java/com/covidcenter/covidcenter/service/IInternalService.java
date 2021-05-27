package com.covidcenter.covidcenter.service;

import com.covidcenter.covidcenter.model.User;

public interface IInternalService {
    Boolean VerifyToken(int userID, String token);
    Boolean VerifyAccess(User user);
}
