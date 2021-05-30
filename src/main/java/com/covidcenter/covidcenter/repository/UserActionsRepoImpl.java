package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.CovidTest;
import com.covidcenter.covidcenter.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserActionsRepoImpl implements UserActionsRepo {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<CovidTest> fetchAll() {
        String sql = "SELECT * FROM covidtest";
        RowMapper<CovidTest> rowMapper = new BeanPropertyRowMapper<>(CovidTest.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public List<Vaccine> fetchAllVaccines() {
        String sql = "SELECT * FROM vaccine";
        RowMapper<Vaccine> rowMapper = new BeanPropertyRowMapper<>(Vaccine.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public int addTest(CovidTest test) {
        String sql = "INSERT INTO covidtest(cpr_number,test_place,test_result,test_time) VALUES(?,?,?,?)";
        return template.update(sql, test.getCprNumber(), test.getTestPlace(), test.getTestResult(), test.getTestTime());
    }

    @Override
    public int addVaccine(Vaccine vaccine) {
        String sql = "INSERT INTO vaccine(cpr_number,vaccine_place,vaccine_date) VALUES(?,?,?)";
        return template.update(sql, vaccine.getCprNumber(), vaccine.getPlace(), vaccine.getTime());
    }

    @Override
    public int changeVaccineStatus(int userID, Vaccine vaccine) {
        String sql = "UPDATE vaccine SET cpr_number = ?,test_place = ?, test_time = ?, WHERE ( userID = ?)";
        return template.update(sql, vaccine.getCprNumber(), vaccine.getPlace(), vaccine.getTime());
    }

    @Override
    public int changeTestStatus(int userID, CovidTest test) {
        String sql = "UPDATE covidtest SET cpr_number = ?,test_place = ?, test_result = ?, test_time = ?, WHERE ( userID = ?)";
        return template.update(sql, test.getCprNumber(), test.getTestPlace(), test.getTestResult(), test.getTestTime());
    }

}
