package com.covidcenter.covidcenter.model;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    int idUser;
    String cprNumber;
    String name;
    String surname;
    @SuppressWarnings("JpaAttributeTypeInspection")
    UserType userType = new UserType(UserTypeCode.user);
    String email;
    String loginTime;
    String password;
    String token;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public User(int idUser, String cprNumber, String name, String surname,
            com.covidcenter.covidcenter.model.UserType userType, String email, String loginTime, String password,
            String token) {
        this.idUser = idUser;
        this.cprNumber = cprNumber;
        this.name = name;
        this.surname = surname;
        this.userType = userType;
        this.email = email;
        this.loginTime = loginTime;
        this.password = password;
        this.token = token;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getHashedPassword() {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
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

    public com.covidcenter.covidcenter.model.UserType getUserType() {
        return userType;
    }

    public void setUserType(com.covidcenter.covidcenter.model.UserType userType) {
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

    public boolean nameValid() throws Exception {
        if (name == null) {
            throw new Exception("Field can not be empty");
        }
        if (name.length() < 1) {
            throw new Exception("Field can not be empty");
        }
        return true;
    }

    public boolean surnameValid() throws Exception {
        if (surname == null) {
            throw new Exception("Field can not be empty");
        }
        if (surname.length() < 1) {
            throw new Exception("Field can not be empty");
        }
        return true;
    }

    public boolean passValid() throws Exception {
        if (password == null) {
            throw new Exception("Field can not be empty");
        }
        if (password.length() < 5) {
            throw new Exception("Minimum 6 characters");
        }
        return true;
    }

    public ArrayList<ValidationError> userValid() {
        ArrayList<ValidationError> errors = new ArrayList<>();
        try {
            nameValid();
        } catch (Exception exception) {
            ValidationError validEN = new ValidationError("Name", exception.getMessage());
            errors.add(validEN);
        }
        try {
            passValid();
        } catch (Exception exception) {
            errors.add(new ValidationError("Password", exception.getMessage()));
        }
        try {
            surnameValid();
        } catch (Exception exception) {
            exception.printStackTrace();
            errors.add(new ValidationError("Surname", exception.getMessage()));
        }
        try {
            emailValid();
        } catch (Exception exception) {
            exception.printStackTrace();
            errors.add(new ValidationError("Email", exception.getMessage()));
        }
        try {
            cprValid();
        } catch (Exception exception) {
            exception.printStackTrace();
            errors.add(new ValidationError("CPR number", exception.getMessage()));
        }
        return errors;

    }

    public boolean cprValid() throws Exception {
        String regexCPR = "^((((0[1-9]|[12][0-9]|3[01])(0[13578]|10|12)(\\d{2}))|(([0][1-9]|[12][0-9]|30)(0[469]|11)(\\d{2}))|((0[1-9]|1[0-9]|2[0-8])(02)(\\d{2}))|((29)(02)(00))|((29)(02)([2468][048]))|((29)(02)([13579][26])))\\d{4})$";
        Pattern CPRregexPattern = Pattern.compile(regexCPR);
        Matcher matcher = CPRregexPattern.matcher(cprNumber);
        if (matcher.matches()) {
            return true;
        }
        throw new Exception("Incorrect CPR");

    }

    public boolean emailValid() throws Exception {
        String regexemail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern emailregexPattern = Pattern.compile(regexemail);
        Matcher matcher = emailregexPattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        throw new Exception("Incorrect email");
    }
}
