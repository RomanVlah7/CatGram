package catgram.controller;

import catgram.model.Post;
import catgram.model.User;
import catgram.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class PostController {

    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/findAllPostsOfUser")
    public List<Map<String, Object>> findAllPostsOfUser(@RequestHeader String UserID){
        return postService.findAllPostsOfUser(UserID);
    }
}