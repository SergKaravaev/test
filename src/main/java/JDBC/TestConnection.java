package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    private static final String url = "jdbc:mysql://localhost:3305/avtoservis";
    private static final String userName = "root";
    private static final String password = "admin";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

        public Connection getConnection() {
            Connection connection = null;

            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection OK");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Connection ERROR");
            }
            return connection;
        }
    }