package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/posts")
/* final 지정 필드 들에 대해서 생성자 주입을 알아서 만들어 준다 */
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    

    /* /를 붙이는 거랑 없는 거랑 다르다 */
    /* 배열[json 형태]로 묶여 클라이언트에 전달 */
    @GetMapping("/list")
    public List<Post> postList() {
            return postService.postList();
    }

    /* http://localhost:8080/posts/1 */
    @GetMapping("/{postId}")
    public Post postDetail(@PathVariable String postId) {
        return new Post(UUID.randomUUID(),"title1","contents1","",LocalDateTime.now());
    }

    /* http://localhost:8080/posts/update?postId=1 */
    @GetMapping("/update")
    public Post updatePost(@RequestParam String postId) {
        return new Post(UUID.randomUUID(),"title1","contents1","",LocalDateTime.now());
    }
    
    
    

    
}