package com.covidcenter.covidcenter.model;

public class Vaccine {
    int userID;
    String cprNumber;
    String place;
    String time;

    public Vaccine() {

    }

    public Vaccine(int userID, String cprNumber, String place, String time) {
        this.userID = userID;
        this.cprNumber = cprNumber;
        this.place = place;
        this.time = time;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCprNumber() {
        return this.cprNumber;
    }

    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
