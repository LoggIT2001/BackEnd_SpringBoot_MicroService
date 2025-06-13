package HappyProject.Proxy_Client.Exception;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(Throwable throwable){
        super(throwable);
    }
}
