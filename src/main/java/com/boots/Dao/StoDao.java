package com.boots.Dao;

import com.boots.entity.Sto;
import java.sql.SQLException;
import java.util.List;

public interface StoDao {
    //create
    void add(Sto sto) throws SQLException;

    //read
    List<Sto> getAll() throws SQLException;

    Sto getById(Long id) throws SQLException;

    //update
    void update(Sto sto) throws SQLException;

    //delete
    void remove(Sto sto) throws SQLException;
}
