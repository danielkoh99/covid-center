package com.covidcenter.covidcenter.enums;

public enum UserTypeCode {
    administrator(1), secretary(2), user(3);

    private int code;

    private UserTypeCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserTypeCode getCodeByNumber(int number) {
        UserTypeCode code = null;
        switch (number) {
            case 1:
                code = UserTypeCode.administrator;
                break;

            case 2:
                code = UserTypeCode.secretary;
                break;
            case 3:
                code = UserTypeCode.user;
                break;
        }
        return code;
    }
}
