package com.boots.Dao;

import com.boots.entity.Avto;
import java.sql.SQLException;
import java.util.List;

public interface AvtoDao {
    //create
    void add(Avto avto) throws SQLException;

    //read
    List<Avto> getAll() throws SQLException;

    Avto getById(Long id) throws SQLException;

    //update
    void update(Avto avto) throws SQLException;

    //delete
    void remove(Avto avto) throws SQLException;
}
