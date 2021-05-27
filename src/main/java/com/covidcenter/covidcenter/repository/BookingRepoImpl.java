package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.enums.BookingTypeCode;
import com.covidcenter.covidcenter.model.Booking;
import com.covidcenter.covidcenter.model.BookingStatus;
import com.covidcenter.covidcenter.model.BookingType;
import com.covidcenter.covidcenter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepoImpl implements IBookingRepo{
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Booking> fetchAll() {
        String sql = "SELECT * FROM booking";
        SqlRowSet sqlRowSet = template.queryForRowSet(sql, null);

        ArrayList<Booking> bookingArrayList=new ArrayList<>();
        while (sqlRowSet.next()){

            Booking tempBooking=new Booking();

            tempBooking.setIdbookings(Integer.valueOf(sqlRowSet.getString("idbookings")));
            tempBooking.setTime(String.valueOf(sqlRowSet.getString("time")));
            tempBooking.setEndTime(String.valueOf(sqlRowSet.getString("endTime")));
            tempBooking.setBookingStatus_idbookingStatus(new BookingStatus(sqlRowSet.getInt("bookingStatus_idbookingStatus")));
            tempBooking.setBookingType_idbookingType(new BookingType((int)sqlRowSet.getInt("bookingType_idbookingType")));
            tempBooking.setUser_id_user(Integer.valueOf(sqlRowSet.getString("user_id_user")));

            bookingArrayList.add(tempBooking);
        }
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return bookingArrayList;

    }
    @Override
    public int createBooking(int userID, Booking booking) {
        String sql = "INSERT INTO booking(time ,endTime,bookingStatus_idbookingStatus,bookingType_idbookingType, user_id_user) VALUES(?,?,?,?,?)";
        return template.update(sql, booking.getTime(), booking.getEndTime(), booking.getBookingStatus_idbookingStatus().getId(), booking.getBookingType_idbookingType().getIdbookingType(),booking.getUser_id_user());
    }

    @Override
    public List<Booking> fetchAll(int userID, String token) {
        SqlRowSet sqlRowSet = template.queryForRowSet("call getbookingsbyID (?)", userID);

        ArrayList<Booking> bookingArrayList=new ArrayList<>();
        while (sqlRowSet.next()){

            Booking tempBooking=new Booking();

            tempBooking.setIdbookings(Integer.valueOf(sqlRowSet.getString("idbookings")));
            tempBooking.setTime(String.valueOf(sqlRowSet.getString("time")));
            tempBooking.setEndTime(String.valueOf(sqlRowSet.getString("endTime")));
            tempBooking.setBookingStatus_idbookingStatus(new BookingStatus(sqlRowSet.getInt("bookingStatus_idbookingStatus")));
            tempBooking.setBookingType_idbookingType(new BookingType((int)sqlRowSet.getInt("bookingType_idbookingType")));
            tempBooking.setUser_id_user(Integer.valueOf(sqlRowSet.getString("user_id_user")));

            bookingArrayList.add(tempBooking);
        }
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return bookingArrayList;
    }

    @Override
    public int updateBooking(int userID, Booking booking) {
        String sql = "UPDATE booking SET time = ?, endTime = ?, bookingStatus_idbookingStatus = ?, bookingType_idbookingType = ?, user_id_user= ? WHERE ( idbookings = ?)";
        return template.update(sql, booking.getTime(), booking.getEndTime(), booking.getBookingStatus_idbookingStatus().getId(), booking.getBookingType_idbookingType().getIdbookingType(),booking.getUser_id_user());
    }

    @Override
    public Booking getBooking(int bookingID) {
        String sql="SELECT * FROM booking WHERE idbookings=?";
        SqlRowSet sqlRowSet = template.queryForRowSet(sql, null);

        ArrayList<Booking> bookingArrayList=new ArrayList<>();
        while (sqlRowSet.next()){

            Booking tempBooking=new Booking();

            tempBooking.setIdbookings(Integer.valueOf(sqlRowSet.getString("idbookings")));
            tempBooking.setTime(String.valueOf(sqlRowSet.getString("time")));
            tempBooking.setEndTime(String.valueOf(sqlRowSet.getString("endTime")));
            tempBooking.setBookingStatus_idbookingStatus(new BookingStatus(sqlRowSet.getInt("bookingStatus_idbookingStatus")));
            tempBooking.setBookingType_idbookingType(new BookingType((int)sqlRowSet.getInt("bookingType_idbookingType")));
            tempBooking.setUser_id_user(Integer.valueOf(sqlRowSet.getString("user_id_user")));

            bookingArrayList.add(tempBooking);
        }
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);

        return bookingArrayList.get(0);
    }

    @Override
    public int deleteBooking(int bookingID) {
        String sql="DELETE FROM booking WHERE idbookings=?";
        return template.update(sql, bookingID);
    }

}
