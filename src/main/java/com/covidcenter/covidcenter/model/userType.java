package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.UserTypeCode;

public class UserType {
    UserTypeCode type;
    int idUserType;

    public UserTypeCode getType() {
        return type;
    }

    public UserType(UserTypeCode type) {
        idUserType = type.getCode();
        this.type = type;
    }

}
