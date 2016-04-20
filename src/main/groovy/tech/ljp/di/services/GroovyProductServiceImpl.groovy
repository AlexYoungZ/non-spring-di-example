package tech.ljp.di.services

import tech.ljp.domain.Product

/**
 * Created by jt on 4/20/16.
 */
class GroovyProductServiceImpl implements ProductService {

    ProductDao productDao

    GroovyProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao
    }

    Product getProductById(Integer id) {
        productDao.getProduct(id)
    }
}
