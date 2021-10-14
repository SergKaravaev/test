package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3305/avtoservis";
        String userName = "root";
        String password = "admin";


        Class.forName("com.mysql.cj.jdbc.Driver");


        try(Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("Connection successful");
        }
    }
}
