package catgram.exceptions.exceptionHandlers;

import catgram.exceptions.InvalidEmailException;
import catgram.exceptions.UserAlreadyExistsException;
import catgram.exceptions.WorkInProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionHendlers {
    @ExceptionHandler
    @Autowired
    public static ResponseEntity<Map<String, String>> userAlreadyExists(UserAlreadyExistsException e) {
        return new ResponseEntity<>(Map.of("Invalid email", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @Autowired
    public static ResponseEntity<Map<String, String>> invalidEmailException(InvalidEmailException e) {
        return new ResponseEntity<>(Map.of("Invalid email", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @Autowired
    public static ResponseEntity<Map<String, String>> workInProgress(WorkInProgress e) {
        return new ResponseEntity<>(
                Map.of("Not ready yet", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
