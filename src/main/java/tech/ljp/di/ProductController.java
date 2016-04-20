package tech.ljp.di;

import tech.ljp.di.services.ProductService;
import tech.ljp.domain.Product;

/**
 * Created by jt on 4/19/16.
 */
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product getProduct(Integer id){
        return productService.getProductById(id);
    }
}
