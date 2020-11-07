package service;

import api.ProductDao;
import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class ProductDaoImplementation implements ProductDao {

    private final String fileName;
    private final String productType;

    public ProductDaoImplementation(String fileName, String productType) {
        this.fileName = fileName;
        this.productType = productType;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProduct(product);

    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {

    }

    @Override
    public void removeProducts(Long productId) throws IOException {

    }

    @Override
    public void removeProductByName(String productName) throws IOException {

    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return null;
    }

    @Override
    public Product getProductById(Long productId) throws IOException {
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        return null;
    }
}
