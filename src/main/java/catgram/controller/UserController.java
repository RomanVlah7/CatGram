package catgram.controller;
import catgram.exceptions.InvalidEmailException;
import catgram.exceptions.UserAlreadyExistsException;
import catgram.exceptions.WorkInProgress;
import catgram.exceptions.exceptionHandlers.ExceptionHendlers;
import catgram.model.User;
import catgram.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public HashMap<String, User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{email}")
    public User findUserByEmail(@PathVariable(required = false) String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("users/find")
    public ResponseEntity<Map<String, String>> findUser(){
        return ExceptionHendlers.workInProgress(new WorkInProgress());
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Map<String, String>> create(@RequestBody User user){
       return userService.create(user);
    }
}
