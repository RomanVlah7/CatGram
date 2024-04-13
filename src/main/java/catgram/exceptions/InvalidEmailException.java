package catgram.exceptions;

import org.springframework.stereotype.Component;

@Component
public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Email is NULL or incorrect");
    }
}
