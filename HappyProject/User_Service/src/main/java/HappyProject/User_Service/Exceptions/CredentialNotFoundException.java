package HappyProject.User_Service.Exceptions;

public class CredentialNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CredentialNotFoundException(){
        super();
    }
    public CredentialNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CredentialNotFoundException(String message) {
        super(message);
    }

    public CredentialNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
