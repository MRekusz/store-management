package dao;

import api.ProductDao;
import entity.Product;
import utils.FileUtils;

import java.io.*;

import java.util.ArrayList;
import java.util.List;


public class ProductDaoImplementation implements ProductDao {


    private final String fileName;
    private final String productType;

    public ProductDaoImplementation(String fileName, String productType) throws IOException {
        this.fileName = fileName;
        this.productType = productType;
        FileUtils.createNewFile(fileName);

    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProduct(product);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public void removeProductsById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for (int i = 0; i < products.size(); i++) {
            boolean isFoundProduct = products.get(i).getId() == productId;
            if (isFoundProduct) {
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (int i = 0; i < products.size(); i++) {
            boolean isProductOnList = products.get(i).getProductName().equals(productName);
            if (isProductOnList) {
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {

        List<Product> products = new ArrayList<>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readOneLine = bufferedReader.readLine();

        while (readOneLine != null) {
            readOneLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return products;
    }

    @Override
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
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            boolean isFoundProduct = product.getProductName().equals(productName);
            if (isFoundProduct) {
                return product;
            }
        }
        return null;
    }

}
