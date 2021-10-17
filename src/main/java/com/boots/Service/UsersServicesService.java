package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.UsersServicesDao;
import com.boots.entity.UsersServices;
import java.sql.*;
import java.util.*;

public class UsersServicesService extends TestConnection implements UsersServicesDao {
    private Connection connection = getConnection();

    @Override
    public void add(UsersServices usersServices) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO users_services (id, id_users, id_services, work_employee) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, usersServices.getId());
            preparedStatement.setLong(2, usersServices.getId_users());
            preparedStatement.setLong(3, usersServices.getId_services());
            preparedStatement.setString(4, usersServices.getWork_employee());


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
    public List<UsersServices> getAll() throws SQLException {
        List<UsersServices> usersServicesList = new ArrayList<>();

        String sql = "SELECT id, id_users, id_services, work_employee FROM users_services";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UsersServices usersServices = new UsersServices();
                usersServices.setId(resultSet.getLong("id"));
                usersServices.setId_users(resultSet.getLong("id_users"));
                usersServices.setId_services(resultSet.getLong("id_services"));
                usersServices.setWork_employee(resultSet.getString("work_employee"));

                usersServicesList.add(usersServices);
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

        return usersServicesList;
    }

    @Override
    public UsersServices getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, id_users, id_services, work_employee FROM users_services WHERE id=?";

        UsersServices usersServices = new UsersServices();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            usersServices.setId(resultSet.getLong("id"));
            usersServices.setId_users(resultSet.getLong("id_users"));
            usersServices.setId_services(resultSet.getLong("id_services"));
            usersServices.setWork_employee(resultSet.getString("work_employee"));

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
        return usersServices;
    }

    @Override
    public void update(UsersServices usersServices) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE usersServices SET id_users=?, id_services=?, work_employee=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, usersServices.getId_users());
            preparedStatement.setLong(2, usersServices.getId_services());
            preparedStatement.setString(3, usersServices.getWork_employee());
            preparedStatement.setLong(4, usersServices.getId());

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
    public void remove(UsersServices usersServices) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM usersServices WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, usersServices.getId());

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
