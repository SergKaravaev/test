package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.StoDao;
import com.boots.entity.Sto;
import java.sql.*;
import java.util.*;

public class StoService  extends TestConnection implements StoDao {

    Connection connection = getConnection();

    @Override
    public void add(Sto sto) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO sto (id_avto) VALUES(?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, sto.getId_avto());

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
    public List<Sto> getAll() throws SQLException {
        List<Sto> stoList = new ArrayList<>();

        String sql = "SELECT id, id_avto FROM sto";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Sto sto = new Sto();
                sto.setId(resultSet.getLong("id"));
                sto.setId_avto(resultSet.getLong("id_avto"));

                stoList.add(sto);
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

        return stoList;
    }

    @Override
    public Sto getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, id_avto FROM sto WHERE id=?";

        Sto sto = new Sto();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            sto.setId(resultSet.getLong("id"));
            sto.setId_avto(resultSet.getLong("id_avto"));

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
        return sto;
    }

    @Override
    public void update(Sto sto) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE sto SET id_avto=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, sto.getId_avto());
            preparedStatement.setLong(2, sto.getId());

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
    public void remove(Sto sto) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM sto WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, sto.getId());

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
