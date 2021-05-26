package com.covidcenter.covidcenter.controller;

import com.covidcenter.covidcenter.model.Secretary;
import com.covidcenter.covidcenter.repository.SecretaryRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SecretaryApi {
    // final String APIPATH = "something/secretary";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SecretaryRepository secretaryRepository;

    @GetMapping("/secretary")
    public String getDetails() {
        Gson gson = new Gson();
        return gson.toJson(secretaryRepository.fetchAll());
    }

    // public String Home() {

    // // return gson.toJson(secretaryRepository.fetchAll());
    // return "hi";
    // }

    // @PostMapping(value = "/children")
    // public List<Child> insertChild(@RequestBody final Child child) {
    // String SQL = "INSERT INTO child (name,age,address,phone_number,email) VALUE (
    // '" + child.getName() + "',"
    // + child.getAge() + ",'" + child.getAddress() + "','" + child.getPhoneNumber()
    // + "','" + child.getEmail()
    // + "')";
    // jdbcTemplate.execute(SQL);
    // return childrenRepository.findAll();
    // }

    // @DeleteMapping(value = "/children/{id}")
    // public List<Child> deleteChild(@PathVariable(value = "id") String id) {
    // String SQL = "DELETE FROM child WHERE id=" + id;
    // jdbcTemplate.execute(SQL);
    // return childrenRepository.findAll();
    // }

    // @PutMapping(value = "/children")
    // public List<Child> updateChild(@RequestBody final Child child) {
    // String SQL = "UPDATE child SET name = '" + child.getName() + "',age = " +
    // child.getAge() + ",address='"
    // + child.getAddress() + "',phone_number='" + child.getPhoneNumber() +
    // "',email='" + child.getEmail()
    // + "' WHERE id=" + child.getId();
    // // System.out.println(SQL);
    // jdbcTemplate.execute(SQL);
    // return childrenRepository.findAll();
    // }
}