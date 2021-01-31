package service;

import api.ProductService;
import dao.ProductDaoImplementation;
import entity.Product;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImplementation implements ProductService {

    private static ProductServiceImplementation instance = null;
    private ProductDaoImplementation productDao = ProductDaoImplementation.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();

    private ProductServiceImplementation() throws IOException {
    }


    public static ProductServiceImplementation getInstance() throws IOException {
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
    public boolean saveProduct(Product product) {

        return false;
    }


}
