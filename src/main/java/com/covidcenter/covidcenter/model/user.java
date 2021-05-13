package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.userTypeCode;

public class user {
    int idUser;
    String cprNumber;
    String name;
    String surname;
    int Age;
    userType userType=new userType(userTypeCode.user);
    String email;
    String loginTime;
    String password;
    String token;
    public user(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }

    public user(int idUser, String cprNumber, String name, String surname, int age, com.covidcenter.covidcenter.model.userType userType, String email, String loginTime, String password, String token) {
        this.idUser = idUser;
        this.cprNumber = cprNumber;
        this.name = name;
        this.surname = surname;
        Age = age;
        this.userType = userType;
        this.email = email;
        this.loginTime = loginTime;
        this.password = password;
        this.token = token;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
    public com.covidcenter.covidcenter.model.userType getUserType() {
        return userType;
    }

    public void setUserType(com.covidcenter.covidcenter.model.userType userType) {
        this.userType = userType;
    }
    public String getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
