package catgram.dao;

import java.util.List;
import java.util.Map;

public interface FollowDao {
    List<Map<String, Object>> getFollowFeed(String userID, int max);
}
