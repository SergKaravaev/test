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

        String sql = "INSERT INTO users (name, surname, username, password, roles) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getSurname());
            preparedStatement.setString(3, users.getUsername());
            preparedStatement.setString(4, users.getPassword());
            preparedStatement.setString(5, users.getRoles());

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
    public Users getById(Long id) throws SQLException
    {
        String sql = "SELECT * FROM users WHERE  id = ?";

        Users users = new Users();
        try(Connection connection = getConnection())
        {
            try(PreparedStatement preparableStatement = connection.prepareStatement(sql))
            {
                preparableStatement.setLong(1, id);

                ResultSet resultSet = preparableStatement.executeQuery();
                if(resultSet.next())
                {
                    users.setId(resultSet.getLong("id"));
                    users.setName(resultSet.getString("name"));
                    users.setSurname(resultSet.getString("surname"));
                    users.setUsername(resultSet.getString("username"));
                    users.setPassword(resultSet.getString("password"));
                    users.setRoles(resultSet.getString("roles"));
                }

            }
        }
        return users;
    }

    @Override
    public void update(Users users) throws SQLException
    {
        String sql = "UPDATE users SET name=?, surname=?, username=?, password=?, roles=? WHERE id=?";
        try(Connection connection = getConnection())
        {
            try(PreparedStatement preparableStatement = connection.prepareStatement(sql))
            {
                preparableStatement.setString(1, users.getName());
                preparableStatement.setString(2, users.getSurname());
                preparableStatement.setString(3, users.getUsername());
                preparableStatement.setString(4, users.getPassword());
                preparableStatement.setString(5, users.getRoles());
                preparableStatement.setLong(6, users.getId());

                preparableStatement.executeUpdate();
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


