package catgram.controller;

import catgram.service.PostFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feed")
public class PostFeedController {
    private PostFeedService postFeedService;

    @Autowired
    public PostFeedController(PostFeedService postFeedService) {
        this.postFeedService = postFeedService;
    }

    @GetMapping("/getFollowFeed")
    public List<Map<String, Object>> getFollowFeed(@RequestParam String UserID, @RequestParam int max){
        return postFeedService.getFollowFeed(UserID, max);
    }
}
