package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {


    List<Product> getAllProducts() throws IOException;
    Integer getProductsCount() throws IOException;


    boolean saveProduct(Product product);



}
