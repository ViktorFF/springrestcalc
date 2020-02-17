package by.springbootrest.calc.controller.exception;

import by.springbootrest.calc.exception.RegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity ex() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
