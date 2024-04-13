package catgram.exceptions;

import org.springframework.stereotype.Component;

@Component
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("User with this Email already exists");
    }
}
