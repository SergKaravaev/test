package com.boots.Service;



import JDBC.TestConnection;
import com.boots.Dao.AvtoDao;
import com.boots.entity.Avto;
import java.sql.*;
import java.util.*;

public class AvtoService extends TestConnection implements AvtoDao {

    Connection connection = getConnection();

    @Override
    public void add(Avto avto) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO avto (id, brant, models, id_users) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, avto.getId());
            preparedStatement.setString(2, avto.getBrant());
            preparedStatement.setString(3, avto.getModels());
            preparedStatement.setLong(4, avto.getId_users());

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
    public List<Avto> getAll() throws SQLException {
        List<Avto> avtoList = new ArrayList<>();

        String sql = "SELECT id, brant, models, id_users FROM avto";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Avto avto = new Avto();
                avto.setId(resultSet.getLong("id"));
                avto.setBrant(resultSet.getString("brant"));
                avto.setModels(resultSet.getString("models"));
                avto.setId_users(resultSet.getLong("id_users"));

                avtoList.add(avto);
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

        return avtoList;
    }

    @Override
    public Avto getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, brant, models, id_users FROM avto WHERE id=?";

        Avto avto = new Avto();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            avto.setId(resultSet.getLong("id"));
            avto.setBrant(resultSet.getString("brant"));
            avto.setModels(resultSet.getString("models"));
            avto.setId_users(resultSet.getLong("id_users"));

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
        return avto;
    }

    @Override
    public void update(Avto avto) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE avto SET brant=?, models=?, id_users=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, avto.getBrant());
            preparedStatement.setString(2, avto.getModels());
            preparedStatement.setLong(3, avto.getId_users());
            preparedStatement.setLong(4, avto.getId());

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
    public void remove(Avto avto) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM avto WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, avto.getId());

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

