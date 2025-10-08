import java.sql.*;

public class DBConfig {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/swingdb", "root", "Dummy@812999");
    }
}