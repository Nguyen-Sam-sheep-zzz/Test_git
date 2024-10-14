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

    public void selectAllProducts() {
        Connection connection = connectionDB();
        Statement statement = null;
        String selectProducts = "select * from products";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectProducts);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int stock = resultSet.getInt("stock");
                System.out.println("|ID: " + id + " | name: " + name + " | price:" + price + " | stock:" + stock + " |");

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
}
