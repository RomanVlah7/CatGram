package catgram.controller;

import catgram.model.Post;
import catgram.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/post")
    public void create(@RequestBody Post post) {
        postService.create(post);
    }

    @GetMapping("posts/{postId}")
    public Post  getPostById(@PathVariable int postId){
        return postService.getById(postId);
    }

    @GetMapping("/posts")
    public List<Post> findAll(
        @RequestParam Integer size,
        @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
        @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to
    )
    {
        if(size == null){
            size = 10;
        }
        return postService.findAll(size, from, to);
    }

    @GetMapping("/posts/debug")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
}