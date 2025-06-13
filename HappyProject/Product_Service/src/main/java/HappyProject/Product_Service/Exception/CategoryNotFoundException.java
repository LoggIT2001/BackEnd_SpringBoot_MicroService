package HappyProject.Product_Service.Exception;

public class CategoryNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(){
        super();
    }

    public CategoryNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public CategoryNotFoundException(String message){
        super(message);
    }

    public CategoryNotFoundException(Throwable throwable){
        super(throwable);
    }
}
