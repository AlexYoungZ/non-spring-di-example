package tech.ljp.di;

import org.junit.Before;
import org.junit.Test;
import tech.ljp.di.services.GroovyProductServiceImpl;
import tech.ljp.di.services.ProductDao;
import tech.ljp.di.services.ProductDaoImpl;
import tech.ljp.di.services.ProductService;
import tech.ljp.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jt on 4/20/16.
 */
public class TestProductControllerGroovyService {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private ProductService service;
    private ProductController controller;

    @Before
    public void setUp() throws Exception {
        //groovy class
        ProductDao dao = new ProductDaoImpl(getDBConnection());
                  //groovy implementation
        service = new GroovyProductServiceImpl(dao);
        controller = new ProductController(service);
    }

    @Test
    public void testGetProduct() throws Exception {

        Product product = controller.getProduct(1);

        assert product != null;

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
