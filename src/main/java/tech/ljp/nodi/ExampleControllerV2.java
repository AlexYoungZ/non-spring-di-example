package tech.ljp.nodi;

import tech.ljp.domain.Product;
import tech.ljp.util.DbHelper;

/**
 * Created by jt on 4/19/16.
 */
public class ExampleControllerV2 {

    public ExampleControllerV2() {
        DbHelper.initDB();
    }

    public Product getProduct(Integer id){
        return DbHelper.getProduct(id);
    }
}
