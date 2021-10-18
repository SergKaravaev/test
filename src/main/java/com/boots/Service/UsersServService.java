package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.UsersServicesDao;
import com.boots.entity.UsersServ;
import java.sql.*;
import java.util.*;

public class UsersServService extends TestConnection implements UsersServicesDao {
    private Connection connection = getConnection();

    @Override
    public void add(UsersServ usersServ) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO users_serv (id_users, id_serv, work_employee) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, usersServ.getId_users());
            preparedStatement.setLong(2, usersServ.getId_serv());
            preparedStatement.setString(3, usersServ.getWork_employee());


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
    public List<UsersServ> getAll() throws SQLException {
        List<UsersServ> usersServList = new ArrayList<>();

        String sql = "SELECT id, id_users, id_serv, work_employee FROM users_serv";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UsersServ usersServ = new UsersServ();
                usersServ.setId(resultSet.getLong("id"));
                usersServ.setId_users(resultSet.getLong("id_users"));
                usersServ.setId_serv(resultSet.getLong("id_serv"));
                usersServ.setWork_employee(resultSet.getString("work_employee"));

                usersServList.add(usersServ);
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

        return usersServList;
    }

    @Override
    public UsersServ getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, id_users, id_serv, work_employee FROM users_serv WHERE id=?";

        UsersServ usersServ = new UsersServ();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            usersServ.setId(resultSet.getLong("id"));
            usersServ.setId_users(resultSet.getLong("id_users"));
            usersServ.setId_serv(resultSet.getLong("id_serv"));
            usersServ.setWork_employee(resultSet.getString("work_employee"));

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
        return usersServ;
    }

    @Override
    public void update(UsersServ usersServ) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE users_serv SET id_users=?, id_serv=?, work_employee=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, usersServ.getId_users());
            preparedStatement.setLong(2, usersServ.getId_serv());
            preparedStatement.setString(3, usersServ.getWork_employee());
            preparedStatement.setLong(4, usersServ.getId());

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
    public void remove(UsersServ usersServ) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM usersServ WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, usersServ.getId());

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
