package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;





@RestController
@RequestMapping("/posts")
public class PostController {

    /* /를 붙이는 거랑 없는 거랑 다르다 */
    /* 배열[json 형태]로 묶여 클라이언트에 전달 */
    @GetMapping("/list")
    public List<Post> postList() {
        return List.of(
            new Post("1","title1","contents1","",LocalDateTime.now()),
            new Post("2","title2","contents2","",LocalDateTime.now()),
            new Post("3","title3","contents3","",LocalDateTime.now())
        );
    }

    /* http://localhost:8080/posts/1 */
    @GetMapping("/{postId}")
    public Post postDetail(@PathVariable String postId) {
        return new Post("1","title1","contents1","",LocalDateTime.now());
    }

    /* http://localhost:8080/posts/update?postId=1 */
    @GetMapping("/update")
    public Post updatePost(@RequestParam String postId) {
        return new Post(postId,"title1","contents1","",LocalDateTime.now());
    }
    
    
    

    
}