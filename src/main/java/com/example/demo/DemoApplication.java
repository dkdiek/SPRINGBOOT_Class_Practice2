package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		List<Post> postList = List.of(
				new Post(UUID.randomUUID(), "Title1", "conents1", "", LocalDateTime.now()),
				new Post(UUID.randomUUID(), "Title2", "conents21", "", LocalDateTime.now()),
				new Post(UUID.randomUUID(), "Title3", "conents31", "", LocalDateTime.now()));
		for (Post p : postList) {
			postRepository.save(p);
		}

		List<User> userList = List.of(
				User.builder().email("matthew@ohhoonim.dev")
						.password(passwordEncoder.encode("1234"))
						.name("matthew")
						.build());
		userRepository.saveAll(userList);
	}

}
