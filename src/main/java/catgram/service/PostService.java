package catgram.service;

import catgram.model.Post;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Service
public class PostService {
    private final ArrayList<Post> posts = new ArrayList<>();

    public Post create(Post post) {
        posts.add(post);
        return post;
    }

    public Post getById(Integer id){
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id){
                return posts.get(i);
            }
        }
        return null;
    }

    public List<Post> findAll(int size, LocalDate from, LocalDate to){
        ArrayList<Post> result = new ArrayList<>();
        for (int i = 0; i < posts.size() && result.size() < size; i++) {
            if(posts.get(i).getCreationDate().isAfter(from) &&
                    posts.get(i).getCreationDate().isBefore(to.plusDays(1))){
                result.add(posts.get(i));
            }
        }
        return result;
    }

    public List<Post> getAllPosts(){
        return posts;
    }
}