package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepoImpl implements IUserRepo {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<user> fetchAll() {
        String sql = "SELECT * FROM user";
        RowMapper<user> rowMapper = new BeanPropertyRowMapper<>(user.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public int addUser(user u) {
        String sql = "INSERT INTO user(cpr_number,name,surname,email,password, token, loginTime,userTypeId) VALUES(?,?,?,?,?,?,?,?)";
        return template.update(sql, u.getCprNumber(), u.getName(), u.getSurname(), u.getEmail(),
                u.getHashedPassword(), u.getToken(), u.getLoginTime(), u.getUserType().getType().getCode());

    }
    @Override
    public int updateUser(user u){
        String sql="UPDATE user SET cpr_number= ?,name = ?, surname = ?, email = ? WHERE (id_user = ?);";
        return template.update(sql,u.getCprNumber(), u.getName(), u.getSurname(), u.getEmail(),u.getIdUser() );
    }

    @Override
    public user getUser(int userID) {
        String sql="SELECT * FROM user WHERE (id_user=?) LIMIT 1";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(user.class),userID);
    }

    @Override
    public user getUser(String email) {
        String sql="SELECT * FROM user WHERE (email=?) LIMIT 1";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(user.class),email);

    }

    @Override
    public String login(int userID) throws Exception {
        String sql="UPDATE user SET token=?, loginTime=? WHERE (id_user=?);";
        UUID token= UUID.randomUUID();
        int result=template.update(sql, token.toString(), LocalDateTime.now().toString(),userID);
        if (result>0) {
            return token.toString();
        } throw new Exception("Login failed");
    }

    @Override
    public Boolean logout(int userID) {
        String sql="UPDATE user SET token=?, loginTime=? WHERE (id_user=?);";

        int result=template.update(sql, "", "",userID);
        if (result>0) {
            return true;
        } return false;
    }
}