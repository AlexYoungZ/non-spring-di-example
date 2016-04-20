package tech.ljp.di;

import org.junit.Before;
import org.junit.Test;
import tech.ljp.di.services.ProductService;
import tech.ljp.di.services.ProductServiceImpl;
import tech.ljp.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jt on 4/19/16.
 */
public class TestProductControllerH2 {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private ProductService service;
    private ProductController controller;

    @Before
    public void setUp() throws Exception {
        service = new ProductServiceImpl(getDBConnection());
        controller = new ProductController(service);
    }

    @Test
    public void testGetProduct() throws Exception {
        Product product = controller.getProduct(1);

        assert product.getId() == 1;

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
