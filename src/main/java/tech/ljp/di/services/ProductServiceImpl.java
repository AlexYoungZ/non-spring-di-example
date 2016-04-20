package tech.ljp.di.services;

import tech.ljp.domain.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jt on 4/19/16.
 */
public class ProductServiceImpl implements ProductService {

    private Connection connection;

    public ProductServiceImpl(Connection connection) {
        this.connection = connection;
        this.initDB();
    }

    public Product getProductById(Integer id) {
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

    private void initDB(){
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
}
