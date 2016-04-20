package tech.ljp.di.services

import spock.lang.Specification
import tech.ljp.domain.Product

/**
 * Created by jt on 4/20/16.
 */
class GroovyProductServiceSpec extends Specification{

    ProductDao productDao
    ProductService service

    void setup() {
        def dao = [:]

        dao.createProduct = {Product product -> return product}
        dao.getProduct = {Integer id -> return new Product(id: id, description: "Groovy is fun")}
        dao.updateProduct = {Product product -> return product}
        dao.deleteProduct = {Integer id  -> null}

        productDao = dao as ProductDao

        service = new GroovyProductServiceImpl(productDao)
    }

    def "Test Get Product"() {

        when:
        def product = service.getProductById(1)

        then:
        product
        product.id == 1
    }
}
