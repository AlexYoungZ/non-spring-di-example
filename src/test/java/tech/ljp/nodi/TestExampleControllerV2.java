package tech.ljp.nodi;

import org.junit.Test;
import tech.ljp.domain.Product;

/**
 * Created by jt on 4/19/16.
 */
public class TestExampleControllerV2 {

    @Test
    public void testGetProduct(){
        ExampleControllerV2 controller = new ExampleControllerV2();

        Product product = controller.getProduct(1);

        assert product != null;

    }
}
