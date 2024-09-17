package catgram.dao.impl;

import catgram.dao.PostDao;
import catgram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PostDaoImpl implements PostDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> findAllPostsOfUser(String UserID) {
        return jdbcTemplate.queryForList("SELECT * FROM cat_post WHERE author_id =? ORDER BY creation_date desc", UserID);
    }
}
