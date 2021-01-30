package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

public class ProductValidator {

    private static ProductValidator instance = null;

    private ProductValidator() {
    }

    public ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    private boolean isPriceNoPositive(Double price) {
        return price < 0.0d;
    }

    private boolean isProductsCountNegative(Integer productCount) {
        return productCount < 0;
    }

    private boolean isWeightNoPositive(Double productWeight) {
        return productWeight < 0.0d;
    }

    private boolean isNameEmpty(String productName) {
        return productName.length() == 0;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductWeightNoPositiveException, ProductCountNegativeException, ProductNameEmptyException {
        if (isPriceNoPositive(product.getPrice())) {
            throw new ProductPriceNoPositiveException("Product price is not positive.");
        }
        if (isProductsCountNegative(product.getProductCount())) {
            throw new ProductWeightNoPositiveException("Product weight is less or equal 0.");
        }

        if (isWeightNoPositive(product.getWeight())) {
            throw new ProductCountNegativeException("Product count is less than 0.");
        }
        if (isNameEmpty(product.getProductName())) {
            throw new ProductNameEmptyException("Product name cannot be empty");
        }
        return true;
    }

}
