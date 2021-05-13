package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.userTypeCode;

public class userType {
    userTypeCode Type;
    int idUserType;

    public userTypeCode getType() {
        return Type;
    }

    public userType(userTypeCode type) {
        idUserType=type.getCode();
        Type = type;
    }

}


