package com.covidcenter.covidcenter.model;

public class ValidationError {
    String field;
    String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
