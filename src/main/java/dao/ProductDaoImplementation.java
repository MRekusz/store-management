package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImplementation implements ProductDao {

    private static ProductDaoImplementation instance = null;
    private final String fileName = "products.data";

    private ProductDaoImplementation() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductDaoImplementation getInstance() {
        if (instance == null) {
            instance = new ProductDaoImplementation();
        }

        return instance;
    }



    @Override
    public List<Product> getAllProducts() throws IOException {

        List<Product> products = new ArrayList<>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String readOneLine = bufferedReader.readLine();

        while (readOneLine != null) {
            Product product = ProductParser.productToString(readOneLine);
            if (product != null) {
                products.add(product);
            }
            bufferedReader.close();
        }
        return products;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        try {
            FileUtils.clearFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
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



}
