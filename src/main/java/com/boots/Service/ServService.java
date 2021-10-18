package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.ServDao;
import com.boots.entity.Serv;
import java.sql.*;
import java.util.*;

public class ServService extends TestConnection implements ServDao {

    Connection connection = getConnection();

    @Override
    public void add(Serv serv) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO serv (id_jobs, id_sto, data, serv_price) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, serv.getId_jobs());
            preparedStatement.setLong(2, serv.getId_sto());
            preparedStatement.setDate(3, serv.getData());
            preparedStatement.setFloat(4, serv.getServ_price());

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
    public List<Serv> getAll() throws SQLException {
        List<Serv> servList = new ArrayList<>();

        String sql = "SELECT id, id_jobs, id_sto, data, serv_price FROM serv";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Serv serv = new Serv();
                serv.setId(resultSet.getLong("id"));
                serv.setId_jobs(resultSet.getLong("id_jobs"));
                serv.setId_sto(resultSet.getLong("id_sto"));
                serv.setData(resultSet.getDate("data"));
                serv.setServ_price(resultSet.getFloat("serv_price"));

                servList.add(serv);
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

        return servList;
    }

    @Override
    public Serv getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, id_jobs, id_sto, data, services_price FROM serv WHERE id=?";

        Serv serv = new Serv();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            serv.setId(resultSet.getLong("id"));
            serv.setId_jobs(resultSet.getLong("id_jobs"));
            serv.setId_sto(resultSet.getLong("id_sto"));
            serv.setData(resultSet.getDate("data"));
            serv.setServ_price(resultSet.getFloat("serv_price"));

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
        return serv;
    }

    @Override
    public void update(Serv serv) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE serv SET id_jobs=?, id_sto=?, data, serv_price=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, serv.getId_jobs());
            preparedStatement.setLong(2, serv.getId_sto());
            preparedStatement.setFloat(3, serv.getServ_price());
            preparedStatement.setDate(4, serv.getData());
            preparedStatement.setLong(5, serv.getId());

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
    public void remove(Serv serv) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM serv WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, serv.getId());

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
