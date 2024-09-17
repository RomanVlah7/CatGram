package catgram.service;

import catgram.dao.impl.FollowDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class PostFeedService {
    private FollowDaoImpl followDaoImpl;

    @Autowired
    public PostFeedService(FollowDaoImpl followDaoImpl) {
        this.followDaoImpl = followDaoImpl;
    }

    public List<Map<String, Object>> getFollowFeed(String UserID, int max){
        return followDaoImpl.getFollowFeed(UserID, max);
    }
}
