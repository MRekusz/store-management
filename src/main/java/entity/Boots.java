package entity;

public class Boots extends Product {


    int size;
    boolean isNaturalSkin;

    public Boots(long id, String productName, double price, double weight, String color, int productCount, int size) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;

    }


    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }


    @Override
    public String toString() {
        return super.toString() + "Boots{" +
                "size='" + size + '\'' +
                ", isNaturalSkin=" + isNaturalSkin +
                '}';
    }

}
