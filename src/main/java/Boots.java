public class Boots extends Product{


    int size;
    boolean isNaturalSkin;

    public Boots(int id, String productName, double price, double weight, String color, int productCount, int size) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;

    }
}
