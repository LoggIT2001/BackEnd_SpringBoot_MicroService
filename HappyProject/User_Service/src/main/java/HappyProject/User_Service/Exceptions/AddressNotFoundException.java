package HappyProject.User_Service.Exceptions;


public class AddressNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public AddressNotFoundException(){
        super();
    }
    public AddressNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    public AddressNotFoundException(String message){
        super(message);
    }
    public AddressNotFoundException(Throwable throwable){
        super(throwable);
    }
}
