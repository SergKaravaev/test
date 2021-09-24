import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        String url = "jdbc:mysql://localhost:3305/AVTOSERVIS";
        String userName = "root";
        String password = "admin";

        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url,userName,password)) {

        }
    }
}
