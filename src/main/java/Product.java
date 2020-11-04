public class Product {


    protected int id;
    String productName;
    public double price;
    double weight;
    String color;
    public int productCount;


    public Product(int id, String productName, double price, double weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }
}
