package com.boots.Dao;

import com.boots.entity.Serv;
import java.sql.SQLException;
import java.util.List;

public interface ServDao {

    //create
    void add(Serv serv) throws SQLException;

    //read
    List<Serv> getAll() throws SQLException;

    Serv getById(Long id) throws SQLException;

    //update
    void update(Serv serv) throws SQLException;

    //delete
    void remove(Serv serv) throws SQLException;
}
