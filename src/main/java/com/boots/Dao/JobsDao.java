package com.boots.Dao;

import com.boots.entity.Jobs;
import java.sql.SQLException;
import java.util.List;

public interface JobsDao {

    //create
    void add(Jobs jobs) throws SQLException;

    //read
    List<Jobs> getAll() throws SQLException;

    Jobs getById(Long id) throws SQLException;

    //update
    void update(Jobs jobs) throws SQLException;

    //delete
    void remove(Jobs jobs) throws SQLException;
}
