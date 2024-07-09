package catgram.dao;

import catgram.model.User;

import java.util.List;
import java.util.Map;

public interface PostDao {
   List<Map<String, Object>> findAllPostsOfUser(String UserID);
}
