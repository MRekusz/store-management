package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Integer getProductsCount();
    Product getProductByName(String productName);
    boolean isProductOnWarehouse(String productName);
    boolean isProductByNameExists (String productName);
    boolean isProductByIdExists (Long productID);

}
