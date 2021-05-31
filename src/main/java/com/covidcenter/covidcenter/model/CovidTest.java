package com.covidcenter.covidcenter.model;

public class CovidTest {
    String test_result;
    String test_place;
    String test_time;
    String cpr_number;
    int user_id;

    public CovidTest() {
    }

    public CovidTest(int userID, String cprNumber, String testPlace, String testResult, String testTime) {
        this.test_result = testResult;
        this.test_place = testPlace;
        this.cpr_number = cprNumber;
        this.user_id = userID;
        this.test_time = testTime;
    }

    public String getTestTime() {
        return this.test_time;
    }

    public void setTestTime(String testTime) {
        this.test_time = testTime;
    }

    public void setUserID(int userID) {
        this.user_id = userID;
    }

    public String getCprNumber() {
        return this.cpr_number;
    }

    public void setCprNumber(String cprNumber) {
        this.cpr_number = cprNumber;
    }

    public String getTestResult() {
        return this.test_result;
    }

    public String getTestPlace() {
        return this.test_place;
    }

    public void setTestPlace(String testPlace) {
        this.test_place = testPlace;
    }

    public int getUserID() {
        return this.user_id;
    }

}
