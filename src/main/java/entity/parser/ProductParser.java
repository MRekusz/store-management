package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product productToString(String productStr, String productType) {

        if (productType.equals("PRODUCT")) {
            return convertToProduct(productStr);
        } else if (productType.equals("CLOTH")) {
            return convertToCloth(productStr);
        } else if (productType.equals("BOOTS")) {
            return convertToBoots(productStr);
        }
        return null;
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        Integer productCount = Integer.parseInt(productInformation[5]);
        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Cloth convertToCloth(String productStr) {
        String[] clothInformation = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(clothInformation[0]);
        String productName = clothInformation[1];
        Float price = Float.parseFloat(clothInformation[2]);
        Float weight = Float.parseFloat(clothInformation[3]);
        String color = clothInformation[4];
        Integer productCount = Integer.parseInt(clothInformation[5]);
        String size = clothInformation[6];
        String material = clothInformation[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Boots convertToBoots(String productStr) {
        String[] productInformation = productStr.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productInformation[0]);
        String productName = productInformation[1];
        Float price = Float.parseFloat(productInformation[2]);
        Float weight = Float.parseFloat(productInformation[3]);
        String color = productInformation[4];
        Integer productCount = Integer.parseInt(productInformation[5]);
        Integer size = Integer.parseInt(productInformation[6]);

        return new Boots(id, productName, price, weight, color, productCount, size);
    }

}


