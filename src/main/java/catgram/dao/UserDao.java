package catgram.dao;

import catgram.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findUserByLogin(String login);
}
