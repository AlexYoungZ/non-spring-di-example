package tech.ljp.di.services

import tech.ljp.domain.Product

/**
 * Created by jt on 4/20/16.
 */
interface ProductDao {

    Product createProduct(Product product)

    Product getProduct(Integer id)

    Product updateProduct(Product product)

    void deleteProduct(Integer id)

}