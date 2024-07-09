package catgram.dao.impl;

import catgram.dao.UserDao;
import catgram.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Slf4j
@Component
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        SqlRowSet userRows = jdbcTemplate.queryForRowSet("SELECT * FROM cat_users WHERE id = ?", login);
        if(userRows.next()){
            String id = userRows.getString("id");
            String username = userRows.getString("username");
            String nickname = userRows.getString("nickname");

            User user = new User(id, username, nickname);
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
