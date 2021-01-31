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
    public Integer getCountProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products
        ) {
            boolean isFoundProduct = product.getProductName().equals(productName);
            if (isFoundProduct) {
                return product;
            }
        }

        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        try {
            for (Product product : getAllProducts()) {
                if (isProductExist(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        try {
            for (Product products : getAllProducts()) {
                if (isProductExist(productName) && products.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            boolean isFoundProduct = product.getId() == productId;
            if (isFoundProduct) {
                return product;
            }
        }
        return null;

    }

    @Override
    public boolean isProductExist(Long productId) {
        Product product = null;

        try {
            product = getProductById(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) return false;

        return true;
    }


    @Override
    public boolean saveProduct(Product product) {
        try {
            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
