package java15.taskjdbc;

import java15.taskjdbc.dao.impl.ProductDao;
import java15.taskjdbc.dao.impl.ProductDaoImpl;
import java15.taskjdbc.models.Product;
import java15.taskjdbc.service.impl.ProductService;
import java15.taskjdbc.service.impl.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProductDaoImpl productDao = new ProductDaoImpl();
        ProductService productService= new ProductServiceImpl(productDao);
//productService.createProductTable();
//        productService.addProduct(new Product("lenovo","9.0",65000));
        System.out.println(productService.getProductById(2L));
//        productService

    }
}
