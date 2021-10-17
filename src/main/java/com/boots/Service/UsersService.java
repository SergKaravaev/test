package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.UsersDao;
import com.boots.entity.Users;
import java.sql.*;
import java.util.*;

public class UsersService extends TestConnection implements UsersDao {

    Connection connection = getConnection();

    @Override
    public void add(Users users) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO users (id, name, surname, username, password, roles) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, users.getId());
            preparedStatement.setString(2, users.getName());
            preparedStatement.setString(3, users.getSurname());
            preparedStatement.setString(4, users.getUsername());
            preparedStatement.setString(5, users.getPassword());
            preparedStatement.setString(6, users.getRoles());

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
    public List<Users> getAll() throws SQLException {
        List<Users> usersList = new ArrayList<>();

        String sql = "SELECT id, name, surname, username, password, roles FROM users";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getLong("id"));
                users.setName(resultSet.getString("name"));
                users.setSurname(resultSet.getString("surname"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setRoles(resultSet.getString("roles"));

                usersList.add(users);
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

        return usersList;
    }

    @Override
    public Users getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, name, surname, username, password, roles FROM users WHERE id=?";

        Users users = new Users();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            users.setId(resultSet.getLong("id"));
            users.setName(resultSet.getString("name"));
            users.setSurname(resultSet.getString("surname"));
            users.setUsername(resultSet.getString("username"));
            users.setPassword(resultSet.getString("password"));
            users.setRoles(resultSet.getString("roles"));

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
        return users;
    }

    @Override
    public void update(Users users) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE users SET name=?, surname=?, username=?, password=?, roles=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getSurname());
            preparedStatement.setString(3, users.getUsername());
            preparedStatement.setString(4, users.getPassword());
            preparedStatement.setString(5, users.getRoles());
            preparedStatement.setLong(6, users.getId());

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
    public void remove(Users users) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM users WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, users.getId());

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


