package exception;

import java.io.IOException;

public class ProductCountNegativeException extends IOException {

    public ProductCountNegativeException(){}

    public ProductCountNegativeException(String message) {super(message);}
}
