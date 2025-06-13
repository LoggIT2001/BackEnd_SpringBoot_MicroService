package HappyProject.Product_Service.Exception;

public class ProductNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(){
        super();
    }

    public ProductNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public ProductNotFoundException(String message){
        super(message);
    }

    public ProductNotFoundException(Throwable throwable){
        super(throwable);
    }
}
