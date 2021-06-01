package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.Booking;
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

    @Autowired
    IBookingRepo bookingRepo;

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
    public int addTest(Booking test) {
        return bookingRepo.createBooking(test.getUser_id_user(),test);
    }

    @Override
    public int addVaccine(Booking vaccine) {
        return bookingRepo.createBooking(vaccine.getUser_id_user(),vaccine);
    }

    @Override
    public int changeVaccineStatus(int userID, Booking vaccine) {
        return bookingRepo.updateBooking(vaccine.getUser_id_user(),vaccine);
    }

    @Override
    public int changeTestStatus(int userID, Booking test) {
        return bookingRepo.updateBooking(test.getUser_id_user(),test);
    }

}
