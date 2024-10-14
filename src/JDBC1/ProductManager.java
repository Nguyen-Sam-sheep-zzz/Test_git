package JDBC1;

import java.sql.*;

public class ProductManager {
    private static final String urlConnection = "jdbc:mysql://localhost:3306/product_manager_database";

    private String username = "root";
    private String password = "123456";

    public Connection connectionDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConnection, username, password);
            System.out.println("connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void selectAllProduct() {
        Connection connection = connectionDB();
        Statement statement = null;
        String selecyAllProduct = "select * from products";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selecyAllProduct);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String detail = resultSet.getString("detail");
                String manufacturer = resultSet.getString("manufacturer");
                int number = resultSet.getInt("number");
                String status = resultSet.getString("status");
                System.out.println("| id:" + id + " | name:" + name + " | price:" + price + " | detail:" + detail + " | manufacturer:" + manufacturer + " | number:" + number + " | status:" + status + " |");
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

    public void updateDetailProduct(int id, String detail) {
        Connection connection = connectionDB();
        PreparedStatement preparedStatement;
        String updateDetailProduct = "update products set detail = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(updateDetailProduct);

            preparedStatement.setString(1, detail);
            preparedStatement.setInt(2, id);

            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                System.out.println("Updated detail successfully " + row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateManufacturerAndPriceProduct(int id, String manufacturer, double price) {
        Connection connection = connectionDB();
        PreparedStatement preparedStatement;
        String updateManufacturerAndPrice = "update products set manufacturer = ?, price = ? where id = ?";

        try {
            preparedStatement = connection.prepareStatement(updateManufacturerAndPrice);

            preparedStatement.setInt(3, id);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(1, manufacturer);

            int row = preparedStatement.executeUpdate();

            if (row != 0) {
                System.out.println("Updated manufacturer and price successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNumberAndStatusProduct(int id, int number, String status) {
        Connection connection = connectionDB();
        PreparedStatement preparedStatement;
        String updateNumberAndStatusProduct = "update products set number = ?, status = ? where id = ?";

        try {
            preparedStatement = connection.prepareStatement(updateNumberAndStatusProduct);

            preparedStatement.setInt(3, id);
            preparedStatement.setString(2, status);
            preparedStatement.setInt(1, number);

            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                System.out.println("Updated number and status successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        Connection connection = connectionDB();
        PreparedStatement preparedStatement;
        String deleteProduct = "delete from products where id = ?";

        try {
            preparedStatement = connection.prepareStatement(deleteProduct);

            preparedStatement.setInt(1, id);

            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                System.out.println("Delete product successfully");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    
}
