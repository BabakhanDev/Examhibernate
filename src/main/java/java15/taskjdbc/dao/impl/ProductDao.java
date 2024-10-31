package java15.taskjdbc.dao.impl;

import java15.taskjdbc.models.Product;

import java.util.List;

public interface ProductDao {
    void createProductTable();
    void addProduct(Product product);
    Product getProductById(Long id);
    String updateProduct(Product product);
    void deleteProduct(Long id);

    List<Product> sortProduct(String ascOrDesc);
    Product getProdWithPrice(int min, int max);
}
