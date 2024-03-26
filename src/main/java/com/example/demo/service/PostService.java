package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.PostMapper;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository; //JPA
    private final PostMapper postMapper; //MYbatis

    public List<Post> postList(String title) {
         //return postRepository.findByTitle(title); //jpa 조건 검색
         return postRepository.findByTitleContains(title); //jpa 조건 검색
         //return postRepository.findAll(); jpa 전체 검색
         //return postMapper.listPost(); // mybatis
    }
    
}
