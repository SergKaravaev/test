package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.JobsDao;
import com.boots.entity.Jobs;
import java.sql.*;
import java.util.*;

public class JobsService extends TestConnection implements JobsDao {

    Connection connection = getConnection();

    @Override
    public void add(Jobs jobs) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO jobs (type_of_work, price) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobs.getType_of_work());
            preparedStatement.setFloat(2, jobs.getPrice());


            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Jobs> getAll() throws SQLException {
        List<Jobs> jobsList = new ArrayList<>();

        String sql = "SELECT id, type_of_work, price  FROM jobs";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Jobs jobs = new Jobs();
                jobs.setId(resultSet.getLong("id"));
                jobs.setType_of_work(resultSet.getString("brant"));
                jobs.setPrice(resultSet.getFloat("models"));

                jobsList.add(jobs);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return jobsList;
    }

    @Override
    public Jobs getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, type_of_work, price FROM jobs WHERE id=?";

        Jobs jobs = new Jobs();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            jobs.setId(resultSet.getLong("id"));
            jobs.setType_of_work(resultSet.getString("type_of_work"));
            jobs.setPrice(resultSet.getFloat("price"));


            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return jobs;
    }

    @Override
    public void update(Jobs jobs) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE jobs SET type_of_work=?, price=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, jobs.getType_of_work());
            preparedStatement.setFloat(2, jobs.getPrice());
            preparedStatement.setLong(3, jobs.getId());

            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Jobs jobs) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM jobs WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, jobs.getId());

            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
