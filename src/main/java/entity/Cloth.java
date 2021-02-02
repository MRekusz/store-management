package entity;

public class Cloth extends Product {

    public static final char Product_Type = 'C';

    String size;
    String material;

    public Cloth(long id, String productName, Float price, Float weight, String color, Integer productCount, String size, String material) {
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
    protected String getBasisProductString() {
        return super.getBasisProductString();
    }

    @Override
    public String toString() {
        return Product_Type + PRODUCT_SEPARATOR + getBasisProductString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + material;
    }
}
