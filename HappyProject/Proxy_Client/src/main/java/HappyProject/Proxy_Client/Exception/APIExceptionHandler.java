package HappyProject.Proxy_Client.Exception;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class APIExceptionHandler {
     @ExceptionHandler(value = {
             FeignException.FeignClientException.class,
             FeignException.FeignServerException.class,
             FeignException.class
     })
    public <T extends FeignException>ResponseEntity<ExceptionMsg> handleProxyException(final T e){
         log.info("APIException handle feign proxy exception");
         final var badRequest = HttpStatus.BAD_REQUEST;
         return new ResponseEntity<>(ExceptionMsg.builder()
                 .msg((e.contentUTF8()))
                 .httpStatus(badRequest)
                 .zonedDateTime(ZonedDateTime.now(ZoneId.systemDefault()))
                 .build(), badRequest);
     }

     @ExceptionHandler(value = {
             MethodArgumentNotValidException.class,
             HttpMessageNotReadableException.class
     })
    public <T extends BindException> ResponseEntity<ExceptionMsg> handlerValidationException(final T e){
         log.info("APIException handle validation exception");
         final var badRequest = HttpStatus.BAD_REQUEST;
         return new ResponseEntity<>(ExceptionMsg.builder()
                 .msg(e.getBindingResult().getFieldError().getDefaultMessage())
                 .httpStatus(badRequest)
                 .zonedDateTime(ZonedDateTime.now(ZoneId.systemDefault()))
                 .build(), badRequest);
     }

     @ExceptionHandler(value = {
             UserNotFoundException.class,
             CredentialNotFoundException.class,
             VerificationTokenNotFoundException.class,
             RatingNotFoundException.class,
             IllegalStateException.class
     })
    public <T extends RuntimeException> ResponseEntity<ExceptionMsg> handlerApiRequestException(final T e){
         log.info("APIException handle API request");
         final var badRequest = HttpStatus.BAD_REQUEST;
         return new ResponseEntity<>(ExceptionMsg.builder()
                 .msg(e.getMessage())
                 .httpStatus(badRequest)
                 .zonedDateTime(ZonedDateTime.now(ZoneId.systemDefault()))
                 .build(), badRequest);
     }

}
