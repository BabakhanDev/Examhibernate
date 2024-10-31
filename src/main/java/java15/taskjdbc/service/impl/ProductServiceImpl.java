package java15.taskjdbc.service.impl;

import java15.taskjdbc.dao.impl.ProductDao;
import java15.taskjdbc.models.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
 private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void createProductTable() {
        productDao.createProductTable();

    }

    @Override
    public void addProduct(Product product) {
productDao.addProduct(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    public String updateProduct(Product product) {
        productDao.updateProduct(product);
        return "Success";
    }

    @Override
    public void deleteProduct(Long id) {
productDao.deleteProduct(id);
    }

    @Override
    public List<Product> sortProduct(String ascOrDesc) {
        return productDao.sortProduct(ascOrDesc);
    }

    @Override
    public Product getProdWithPrice(int min, int max) {
        return productDao.getProdWithPrice(min, max);
    }
}
