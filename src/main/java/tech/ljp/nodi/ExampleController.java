package tech.ljp.nodi;

import tech.ljp.domain.Product;

import java.sql.*;

public class ExampleController {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    public ExampleController() {
        Connection connection = getDBConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE PRODUCT(id int primary key, description varchar(255))");
            stmt.execute("INSERT INTO PRODUCT(id, description) VALUES(1, 'Test Product')");
             connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(Integer id){
        Connection connection = getDBConnection();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from PRODUCT where id = " + id.toString());

            rs.next();

            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
