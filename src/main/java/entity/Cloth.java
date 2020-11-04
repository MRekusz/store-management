package entity;

public class Cloth extends Product {


    String size;
    String material;

    public Cloth(int id, String productName, Float price, Float weight, String color, Integer productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;

    }

    @Override
    public String toString() {
        return super.toString() + "Cloth{" +
                "size='" + size + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
