package com.covidcenter.covidcenter.repository;

import java.util.List;

import com.covidcenter.covidcenter.model.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SecretaryRepository implements SecretaryRepo {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Secretary> fetchAll() {
        String sql = "SELECT * FROM secretary";
        RowMapper<Secretary> rowMapper = new BeanPropertyRowMapper<>(Secretary.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public int updateUser(Secretary u) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Secretary getUser(int userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Secretary getUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String login(int userID) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean logout(int userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Secretary u) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int changeTestResult(int cprNumber) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addVaccine(int cprNumber) {
        // TODO Auto-generated method stub
        return 0;
    }

}
