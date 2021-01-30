package exception;

import java.io.IOException;

public class ProductPriceNoPositiveException extends IOException {

    public ProductPriceNoPositiveException(){}

    public ProductPriceNoPositiveException(String message){super(message);}
}
