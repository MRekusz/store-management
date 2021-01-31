package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {


    List<Product> getAllProducts() throws IOException;
    Integer getProductsCount() throws IOException;
    Product getProductByName(String productName) throws IOException;
    boolean isProductOnWarehouse(String productName);
    boolean isProductByNameExists (String productName);
    boolean isProductByIdExists (Long productID);
    boolean saveProduct(Product product);



}
