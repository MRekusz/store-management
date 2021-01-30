package exception;

import java.io.IOException;

public class ProductNameEmptyException extends IOException {

    public ProductNameEmptyException(){}

    public ProductNameEmptyException(String message){super(message);}
}
