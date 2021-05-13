package com.covidcenter.covidcenter.repository;

import com.covidcenter.covidcenter.model.user;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements IUserRepo{
    @Autowired
    JdbcTemplate template;

    @Override
    public List<user> fetchAll() {
        String sql="SELECT * FROM user";
        RowMapper<user> rowMapper= new BeanPropertyRowMapper<>(user.class);
        return template.query(sql,rowMapper);
    }

    @Override
    public int addUser(user u) {
        String sql ="INSERT INTO user(cpr_number,name,surname,age,email,password, token, loginTime,userTypeId) VALUES(?,?,?,?,?,?,?,?,?)";
        return template.update(sql,u.getCprNumber(),u.getName(),u.getSurname(),u.getAge(),u.getEmail(),u.getPassword(),u.getToken(),u.getLoginTime(),u.getUserType().getType().getCode());

    }
}
