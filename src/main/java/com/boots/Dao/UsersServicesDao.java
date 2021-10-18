package com.boots.Dao;

import com.boots.entity.UsersServ;
import java.sql.SQLException;
import java.util.List;

public interface UsersServicesDao {
    //create
    void add(UsersServ usersServ) throws SQLException;

    //read
    List<UsersServ> getAll() throws SQLException;

    UsersServ getById(Long id) throws SQLException;

    //update
    void update(UsersServ usersServ) throws SQLException;

    //delete
    void remove(UsersServ usersServ) throws SQLException;
}
