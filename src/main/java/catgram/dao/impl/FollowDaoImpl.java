package catgram.dao.impl;

import catgram.dao.FollowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FollowDaoImpl implements FollowDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FollowDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getFollowFeed(String userID, int max){
        return jdbcTemplate.queryForList("SELECT author FROM cat_follow WHERE subscriber = ? LIMIT ?", userID, max);
    }
}
