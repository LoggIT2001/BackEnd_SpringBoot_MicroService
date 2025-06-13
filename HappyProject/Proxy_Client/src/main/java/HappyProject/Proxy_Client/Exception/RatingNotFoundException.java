package HappyProject.Proxy_Client.Exception;

import java.io.Serial;

public class RatingNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public RatingNotFoundException(){
        super();
    }
    public RatingNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    public RatingNotFoundException(String message){
        super(message);
    }
    public RatingNotFoundException(Throwable throwable){
        super(throwable);
    }
}
