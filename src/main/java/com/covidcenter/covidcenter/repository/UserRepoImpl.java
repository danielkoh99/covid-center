package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.enums.UserTypeCode;
import com.covidcenter.covidcenter.model.User;
import com.covidcenter.covidcenter.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepoImpl implements IUserRepo {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<User> fetchAll() {
        String sql = "SELECT * FROM user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public int toggle(int userID, UserTypeCode type) {
        String sql = "UPDATE user SET userTypeId= ? WHERE (id_user = ?);";
        return template.update(sql, type.getCode(),userID);
    }

    @Override
    public int addUser(User u) {
        String sql = "INSERT INTO user(cpr_number,name,surname,email,password, token, loginTime,userTypeId) VALUES(?,?,?,?,?,?,?,?)";
        return template.update(sql, u.getCprNumber(), u.getName(), u.getSurname(), u.getEmail(), u.getHashedPassword(),
                u.getToken(), u.getLoginTime(), u.getUserType().getType().getCode());

    }

    @Override
    public int updateUser(User u) {
        String sql = "UPDATE user SET cpr_number= ?,name = ?, surname = ?, email = ? WHERE (id_user = ?);";
        return template.update(sql, u.getCprNumber(), u.getName(), u.getSurname(), u.getEmail(), u.getIdUser());
    }

    @Override
    public User getUser(int userID) {
        String sql = "SELECT * FROM user WHERE (id_user=?) LIMIT 1";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userID);
        sql = "SELECT userTypeId FROM user WHERE email='"+userID+"' LIMIT 1";
        ResultSetExtractor<Integer> integerResultSetExtractor = new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.findColumn("userTypeId");
            }
        };
        int type = template.query(sql,integerResultSetExtractor);
        switch (type){
            case 1: user.setUserType(new UserType(UserTypeCode.administrator));
                break;
            case 2: user.setUserType(new UserType(UserTypeCode.secretary));
                break;
            case 3: user.setUserType(new UserType(UserTypeCode.user));
                break;
        }
        return user;


    }

    @Override
    public User getUser(String email) {
        String sql = "SELECT * FROM user WHERE (email=?) LIMIT 1";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), email);
        String sql2 = "SELECT userTypeId FROM user WHERE email = ?";
        Integer type = template.queryForObject(sql2, new Object[]{email}, Integer.class);
        switch (type){
            case 1:{
                user.setUserType(new UserType(UserTypeCode.administrator));
                break;
            }
            case 2: {
                user.setUserType(new UserType(UserTypeCode.secretary));
                break;
            }
            case 3: {
                user.setUserType(new UserType(UserTypeCode.user));
                break;
            }
        }
        return user;
    }

    @Override
    public String login(int userID) throws Exception {
        String sql = "UPDATE user SET token=?, loginTime=? WHERE (id_user=?);";
        UUID token = UUID.randomUUID();
        int result = template.update(sql, token.toString(), LocalDateTime.now().toString(), userID);
        if (result > 0) {
            return token.toString();
        }
        throw new Exception("Login failed");
    }

    @Override
    public Boolean logout(int userID) {
        String sql = "UPDATE user SET token=?, loginTime=? WHERE (id_user=?);";

        int result = template.update(sql, "", "", userID);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
