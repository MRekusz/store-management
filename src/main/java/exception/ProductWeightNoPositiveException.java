package exception;

import java.io.IOException;

public class ProductWeightNoPositiveException extends IOException {

public ProductWeightNoPositiveException(){}

public ProductWeightNoPositiveException(String message){super(message);}

}
