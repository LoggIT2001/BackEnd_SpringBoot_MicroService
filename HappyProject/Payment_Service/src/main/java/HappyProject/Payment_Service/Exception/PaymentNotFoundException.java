package HappyProject.Payment_Service.Exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;


public class PaymentNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PaymentNotFoundException(){
        super();
    }

    public PaymentNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public PaymentNotFoundException(String message){
        super(message);
    }

    public PaymentNotFoundException(Throwable throwable){
        super(throwable);
    }
}
