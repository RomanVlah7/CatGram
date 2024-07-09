package catgram.controller;

import catgram.model.User;
import catgram.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/users")
@Data
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/findByLogin/")
    public Optional<User> findUserByID(@RequestHeader String login) {
        return userService.findUserByLogin(login);
    }

    @GetMapping("getAll")
    public HashMap<String, User> getAllUsers() {
        return null;
    }

}
