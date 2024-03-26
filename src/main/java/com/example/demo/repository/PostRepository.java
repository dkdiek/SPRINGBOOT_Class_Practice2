package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {

    //query creation 메소드명을 이용해 쿼리 작성
    List<Post> findByTitle(String title);//where
    List<Post> findByTitleContains(String title);//like




    
} 
