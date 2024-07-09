package catgram.service;

import catgram.dao.impl.PostDaoImpl;
import catgram.dao.impl.UserDaoImpl;
import catgram.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private PostDaoImpl postDaoImpl;

    @Autowired
    public PostService(PostDaoImpl postDaoImpl) {
        this.postDaoImpl = postDaoImpl;
    }

    public List<Map<String, Object>> findAllPostsOfUser(String UserID){
        return postDaoImpl.findAllPostsOfUser(UserID);
    }
}