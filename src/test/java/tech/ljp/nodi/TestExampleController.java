package tech.ljp.nodi;

import org.junit.Test;
import tech.ljp.domain.Product;

/**
 * Created by jt on 4/19/16.
 */
public class TestExampleController {

    @Test
    public void testGetProduct(){
        ExampleController controller = new ExampleController();

        Product product = controller.getProduct(1);

        assert product != null;

    }
}
