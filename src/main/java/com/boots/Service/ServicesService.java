package com.boots.Service;

import JDBC.TestConnection;
import com.boots.Dao.ServicesDao;
import com.boots.entity.Services;
import java.sql.*;
import java.util.*;

public class ServicesService extends TestConnection implements ServicesDao {

    Connection connection = getConnection();

    @Override
    public void add(Services services) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO services (id, id_jobs, id_sto, services_price) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, services.getId());
            preparedStatement.setLong(2, services.getId_jobs());
            preparedStatement.setLong(3, services.getId_sto());
            preparedStatement.setFloat(4, services.getServices_price());

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
    public List<Services> getAll() throws SQLException {
        List<Services> servicesList = new ArrayList<>();

        String sql = "SELECT id, id_jobs, id_sto, services_price FROM services";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Services services = new Services();
                services.setId(resultSet.getLong("id"));
                services.setId_jobs(resultSet.getLong("id_jobs"));
                services.setId_sto(resultSet.getLong("id_sto"));
                services.setServices_price(resultSet.getFloat("services_price"));

                servicesList.add(services);
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

        return servicesList;
    }

    @Override
    public Services getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, id_jobs, id_sto, services_price FROM services WHERE id=?";

        Services services = new Services();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            services.setId(resultSet.getLong("id"));
            services.setId_jobs(resultSet.getLong("id_jobs"));
            services.setId_sto(resultSet.getLong("id_sto"));
            services.setServices_price(resultSet.getFloat("services_price"));

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
        return services;
    }

    @Override
    public void update(Services services) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE services SET id_jobs=?, id_sto=?, services_price=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, services.getId_jobs());
            preparedStatement.setLong(2, services.getId_sto());
            preparedStatement.setFloat(3, services.getServices_price());
            preparedStatement.setLong(4, services.getId());

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
    public void remove(Services services) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM services WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, services.getId());

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
