package HappyProject.User_Service.Exceptions;

public class UserObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserObjectNotFoundException() {
        super();
    }

    public UserObjectNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UserObjectNotFoundException(String message) {
        super(message);
    }

    public UserObjectNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
