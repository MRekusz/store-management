package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImplementation;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImplementation implements ProductService {

    private static ProductServiceImplementation instance = null;
    private ProductServiceImplementation productServiceImplementation = ProductServiceImplementation.getInstance();
    private ProductDao productDao = new ProductDaoImplementation("products.data", "Product");

    //    private ProductServiceImplementation(){}

    private static ProductServiceImplementation getInstance() throws IOException {
        if (instance == null) {
            instance = new ProductServiceImplementation();
        }
        return instance;
    }

    List<Product> products;

    public ProductServiceImplementation() throws IOException {
        products = new ArrayList<>();
    }

    public ProductServiceImplementation(List<Product> products) throws IOException {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Integer getProductsCount() {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        for (Product product : products) {
            if (isProductByNameExists(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductByNameExists(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductByIdExists(Long productID) {
        for (Product product : products) {
            if (product.getId() == productID) {
                return true;
            }
        }
        return false;
    }
}
