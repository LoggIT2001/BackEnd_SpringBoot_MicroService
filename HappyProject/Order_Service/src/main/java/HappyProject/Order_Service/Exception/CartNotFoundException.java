package HappyProject.Order_Service.Exception;

public class CartNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CartNotFoundException(){
        super();
    }

    public CartNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public CartNotFoundException(String message){
        super(message);
    }

    public CartNotFoundException(Throwable throwable){
        super(throwable);
    }
}
