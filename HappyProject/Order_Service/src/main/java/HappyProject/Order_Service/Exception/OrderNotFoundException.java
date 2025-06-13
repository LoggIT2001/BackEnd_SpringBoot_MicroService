package HappyProject.Order_Service.Exception;

public class OrderNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public OrderNotFoundException(){
        super();
    }

    public OrderNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public OrderNotFoundException(String message){
        super(message);
    }

    public OrderNotFoundException(Throwable throwable){
        super(throwable);
    }
}
