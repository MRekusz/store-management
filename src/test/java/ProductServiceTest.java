import api.ProductService;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import org.junit.Assert;
import org.junit.Test;
import service.ProductServiceImplementation;
import service.UserServiceImplementation;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {


    @Test
    public void getAllProductTest() {
        List<Product> products = new ArrayList<>();
        products.add(new Cloth(1, "cloth1", 10.5f, 11.3f, "Black", 1, "L", "cotton"));
        products.add(new Boots(2, "shoes1", 20, 1.1, "Black", 1, 44));

        ProductServiceImplementation productServiceImplementation = new ProductServiceImplementation(products);
        List<Product> productsFromTestClass = productServiceImplementation.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void getProductCountTest() {
        List<Product> products = new ArrayList<>();
        products.add(new Cloth(1, "cloth1", 10.5f, 11.3f, "Black", 1, "L", "cotton"));
        products.add(new Boots(2, "shoes1", 20, 1.1, "Black", 1, 44));

        ProductServiceImplementation productServiceImplementation = new ProductServiceImplementation(products);
        int result = productServiceImplementation.getProductsCount();
        Assert.assertEquals(products.size(), result);
    }

    @Test
    public void getProductByNameTest() {
        List<Product> products = new ArrayList<>();
        Product cloth = new Cloth(1, "cloth1", 10.5f, 11.3f, "Black", 1, "L", "cotton");
        products.add(cloth);
//        products.add(new Boots(2, "shoes1", 20, 1.1, "Black", 1, 44));

        ProductServiceImplementation productServiceImplementation = new ProductServiceImplementation(products);
        Product product = productServiceImplementation.getProductByName("cloth1");

        Assert.assertEquals(cloth, product);
    }

    @Test
    public void isProductOnWarehouseTest() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(2, "Boots", 20, 1.1, "Black", 1, 44));

        ProductServiceImplementation productServiceImplementation = new ProductServiceImplementation(products);
        boolean isProductOnWareHouse = productServiceImplementation.isProductOnWarehouse("Boots");

        Assert.assertTrue(isProductOnWareHouse);
    }

    @Test
    public void isProductByNameExistsTest() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(2, "shoes1", 20, 1.1, "Black", 1, 44));

        ProductServiceImplementation productServiceImplementation = new ProductServiceImplementation(products);
        boolean isProductByNameExists = productServiceImplementation.isProductByNameExists("shoes1");

        Assert.assertTrue(isProductByNameExists);
    }


    @Test
    public void isProductByIdExistsTest() {
        List<Product> products = new ArrayList<>();
        products.add(new Cloth(1L, "cloth1", 10.5f, 11.3f, "Black", 1, "L", "cotton"));

        ProductServiceImplementation productServiceImplementation = new ProductServiceImplementation(products);
        boolean isProductByIdExists = productServiceImplementation.isProductByIdExists(1L);

        Assert.assertTrue(isProductByIdExists);
    }

}
