package entity;

public class Product {


    public static final String PRODUCT_SEPARATOR = "#";
    public static final char Product_Type = 'P';
    protected long id;
    String productName;
    public double price;
    double weight;
    String color;
    public int productCount;



    public Product(long id, String productName, double price, double weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                id + PRODUCT_SEPARATOR +
                productName + '\'' + PRODUCT_SEPARATOR +
                price + '\'' + PRODUCT_SEPARATOR +
                price + '\'' + PRODUCT_SEPARATOR +
                weight + '\'' + PRODUCT_SEPARATOR +
                color + '\'' + PRODUCT_SEPARATOR +
                productCount + '\'' +
                '}';
    }


}
