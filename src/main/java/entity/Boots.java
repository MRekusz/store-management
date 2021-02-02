package entity;

public class Boots extends Product {

    public static final char Product_Type = 'B';
    int size;
    boolean isNaturalSkin;

    public Boots(long id, String productName, double price, double weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;

    }


    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    protected String getBasisProductString() {
        return super.getBasisProductString();
    }

    @Override
    public String toString() {
        return Product_Type + PRODUCT_SEPARATOR + getBasisProductString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + isNaturalSkin;
    }

}
