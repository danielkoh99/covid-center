package com.covidcenter.covidcenter.model;

public class CovidTest {
    String testResult;
    String testPlace;
    String testTime;
    String cprNumber;
    int userID;

    public CovidTest() {
    }

    public CovidTest(int userID, String cprNumber, String testPlace, String testResult, String testTime) {
        this.testResult = testResult;
        this.testPlace = testPlace;
        this.cprNumber = cprNumber;
        this.userID = userID;
        this.testTime = testTime;
    }

    public String getTestTime() {
        return this.testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
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

    public String getTestResult() {
        return this.testResult;
    }

    public void setTestResultTypeId(String testResult) {
        this.testResult = testResult;
    }

    public String getTestPlace() {
        return this.testPlace;
    }

    public void setTestPlace(String testPlace) {
        this.testPlace = testPlace;
    }

    public int getUserID() {
        return this.userID;
    }

}
