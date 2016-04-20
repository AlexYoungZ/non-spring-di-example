package tech.ljp.di;

import org.junit.Before;
import org.junit.Test;
import tech.ljp.di.services.ProductService;
import tech.ljp.domain.Product;

/**
 * Created by jt on 4/19/16.
 */
public class TestProductController {

    private ProductService service;
    private ProductController controller;

    @Before
    public void setup(){
        service = new ProductService() {
            public Product getProductById(Integer id) {
                Product product = new Product();
                product.setId(2);
                product.setDescription("My Description");
                return product;
            }
        };

        controller = new ProductController(service);
    }

    @Test
    public void testGetProduct() throws Exception {

        Product product = controller.getProduct(1);

        assert product.getId().equals(2);
    }
}
