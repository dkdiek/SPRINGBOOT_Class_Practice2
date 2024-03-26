package com.example.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    // username을 email로 쓸거기때문에 query 만들어 놓는다
    public Optional<User> findByEmail(String email);

}
