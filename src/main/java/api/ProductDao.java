package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts() throws IOException;

    void saveProduct(Product product) throws IOException;
    void saveProducts(List<Product> products) throws FileNotFoundException;

    void removeProductsById(Long productId) throws IOException;
    void removeProductByName(String productName) throws IOException;

}
