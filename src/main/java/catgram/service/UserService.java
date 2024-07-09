package catgram.service;

import catgram.dao.impl.UserDaoImpl;
import catgram.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserService(UserDaoImpl getUserDaoImpl, UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public User findByEmail(String email) {
        return null;
    }

    public Optional<User> findUserByLogin(String login) {
        return userDaoImpl.findUserByLogin(login);
    }
}
