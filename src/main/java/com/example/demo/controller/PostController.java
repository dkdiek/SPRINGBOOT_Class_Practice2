package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    
    

    
}