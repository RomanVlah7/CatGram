package catgram.service;

import catgram.exceptions.InvalidEmailException;
import catgram.exceptions.exceptionHandlers.ExceptionHendlers;
import catgram.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserService {
    private final HashMap<String, User> users = new HashMap<>();

    public ResponseEntity<Map<String, String>> create(User user) {
        if (user.getEmail() == null || user.getEmail().equalsIgnoreCase("null")) {
            System.out.println("Invalid email");
            return ExceptionHendlers.invalidEmailException(new InvalidEmailException());
        }
        String newUserEmail = user.getEmail();
        if (users.containsKey(newUserEmail)) {
            return ExceptionHendlers.invalidEmailException(new InvalidEmailException());
        } else {
            users.put(user.getEmail(), user);
            log.trace(user.toString());
            return new ResponseEntity<Map<String, String>>(HttpStatus.OK);
        }
    }

    public HashMap<String, User> getAllUsers() {
        log.trace("Current number of users{}", users.size());
        return users;
    }

    public User findByEmail(String email){
        return users.get(email);
    }
}
