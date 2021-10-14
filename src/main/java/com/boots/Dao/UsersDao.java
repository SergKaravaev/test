package com.boots.Dao;

import com.boots.entity.Users;
import java.sql.SQLException;
import java.util.List;

public interface UsersDao {

    //create
    void add(Users users) throws SQLException;

    //read
    List<Users> getAll() throws SQLException;

    Users getById(Long id) throws SQLException;

    //update
    void update(Users users) throws SQLException;

    //delete
    void remove(Users users) throws SQLException;

}
