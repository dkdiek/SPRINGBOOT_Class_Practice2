package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PostService {
    private final PostRepository postRepository; //JPA

    public List<Post> postList() {
         return postRepository.findAll(); //jpa 조건 검색
    }
    
}
