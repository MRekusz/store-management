package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImplementation implements ProductService {

    List<Product> products;

    public ProductServiceImplementation() {
        products = new ArrayList<Product>();
    }

    public ProductServiceImplementation(List<Product> products) {
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
