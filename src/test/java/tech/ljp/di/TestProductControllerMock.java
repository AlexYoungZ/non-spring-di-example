package tech.ljp.di;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tech.ljp.di.services.ProductService;
import tech.ljp.domain.Product;

import static org.mockito.Mockito.*;
/**
 * Created by jt on 4/19/16.
 */
public class TestProductControllerMock {

    private ProductService service;
    private ProductController controller;

    @Before
    public void setup(){
        Product product = new Product();
        product.setId(3);
        product.setDescription("I was built with Mockito");

        service = Mockito.mock(ProductService.class);

        when(service.getProductById(1)).thenReturn(product);

        controller = new ProductController(service);
    }

    @Test
    public void testGetProduct() throws Exception {
        Product product = controller.getProduct(1);

        assert product.getId().equals(3);
        verify(service, times(1)).getProductById(1);

    }
}
