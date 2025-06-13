package HappyProject.Proxy_Client.Exception;

import java.io.Serial;

public class VerificationTokenNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public VerificationTokenNotFoundException(){
        super();
    }

    public VerificationTokenNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public VerificationTokenNotFoundException(String message){
        super(message);
    }

    public VerificationTokenNotFoundException(Throwable throwable){
        super(throwable);
    }
}
