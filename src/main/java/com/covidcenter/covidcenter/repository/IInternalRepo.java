package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.User;

public interface IInternalRepo {
    Boolean VerifyToken(int userID, String token);
    Boolean VerifyAccess(User user);
}
