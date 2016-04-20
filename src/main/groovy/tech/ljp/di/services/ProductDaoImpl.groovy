package tech.ljp.di.services

import tech.ljp.domain.Product

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

/**
 * Created by jt on 4/20/16.
 */
class ProductDaoImpl implements ProductDao {

    Connection connection

    ProductDaoImpl(Connection connection) {
        this.connection = connection
        initDB()
    }

    Product createProduct(Product product) {
        def stmt = connection.createStatement()

        stmt.execute("INSERT INTO PRODUCT(id, description) VALUES(${product.id}, '${product.description}')")

        product
    }

    Product getProduct(Integer id) {
        def stmt = connection.createStatement()
        ResultSet rs = stmt.executeQuery("select * from PRODUCT where id = " + id.toString())
        rs.next()
        new Product(id: rs.getInt(id), description: rs.getString('description'))
    }

    Product updateProduct(Product product) {
        def stmt = connection.createStatement()
        ResultSet rs = stmt.executeQuery("UPDATE PRODUCT where id = ${product.id} SET desription = ${product.description}" )
        product
    }

    void deleteProduct(Integer id) {
        def stmt = connection.createStatement()
        stmt.executeQuery("DELETE from PRODUCT where id = ${product.id}" )
    }

    private void initDB(){
        Statement stmt = null

        try {
            stmt = connection.createStatement()
            stmt.execute("CREATE TABLE PRODUCT(id int primary key, description varchar(255))")
            stmt.execute("INSERT INTO PRODUCT(id, description) VALUES(1, 'Test Product')")
            connection.commit()
        } catch (e) {
            e.printStackTrace()
        }
    }
}
