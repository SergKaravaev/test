package com.boots.Dao;

import com.boots.entity.UsersServices;
import java.sql.SQLException;
import java.util.List;

public interface UsersServicesDao {
    //create
    void add(UsersServices usersServices) throws SQLException;

    //read
    List<UsersServices> getAll() throws SQLException;

    UsersServices getById(Long id) throws SQLException;

    //update
    void update(UsersServices usersServices) throws SQLException;

    //delete
    void remove(UsersServices usersServices) throws SQLException;
}
