package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	private final PostRepository postRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		List<Post> postList = List.of(
            new Post(UUID.randomUUID(),"Title1","conents1","",LocalDateTime.now()),
            new Post(UUID.randomUUID(),"Title2","conents21","",LocalDateTime.now()),
            new Post(UUID.randomUUID(),"Title3","conents31","",LocalDateTime.now())
         );

		 postRepository.saveAll(postList);
	}

}
