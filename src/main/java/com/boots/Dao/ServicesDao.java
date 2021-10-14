package com.boots.Dao;

import com.boots.entity.Services;
import java.sql.SQLException;
import java.util.List;

public interface ServicesDao {

    //create
    void add(Services services) throws SQLException;

    //read
    List<Services> getAll() throws SQLException;

    Services getById(Long id) throws SQLException;

    //update
    void update(Services services) throws SQLException;

    //delete
    void remove(Services services) throws SQLException;
}
