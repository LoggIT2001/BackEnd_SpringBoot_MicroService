package HappyProject.Proxy_Client.Exception;

import java.io.Serial;

public class IllegalAuthenticationCredentialsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public IllegalAuthenticationCredentialsException(){
        super();
    }

    public IllegalAuthenticationCredentialsException(String message, Throwable throwable){
        super(message, throwable);
    }

    public IllegalAuthenticationCredentialsException(String message){
        super(message);
    }

    public IllegalAuthenticationCredentialsException(Throwable throwable){
        super(throwable);
    }
}
