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
    private ProductDao productDao = new ProductDaoImplementation("products.data", "PRODUCT");


    private ProductServiceImplementation() {
    }


    public static ProductServiceImplementation getInstance() {
        if (instance == null) {
            instance = new ProductServiceImplementation();
        }
        return instance;
    }


    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public Integer getProductsCount() throws IOException {
        return getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        try {
            for (Product product : getAllProducts()) {
                if (isProductByNameExists(productName) && product.getProductCount() > 0) {
                    return true;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductByNameExists(String productName) {

        Product product = null;

        try {
            product = productDao.getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }

    @Override
    public boolean isProductByIdExists(Long productID) {
        Product product = null;
        try {
            product = productDao.getProductById(productID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }
}
