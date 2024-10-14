package JDBC2;

import java.net.URLConnection;
import java.sql.*;

public class JDBC2Manager {
    private static final String URLconnection = "jdbc:mysql://localhost:3306/BTJDBC2";
    private String username = "root";
    private String password = "123456";

    public Connection connectionDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URLconnection, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void he() {
        System.out.println("he");
    }
}
