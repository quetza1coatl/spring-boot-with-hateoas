package com.quetzalcoatl.springbootcoursewithhateoas;

import com.quetzalcoatl.springbootcoursewithhateoas.model.Role;
import com.quetzalcoatl.springbootcoursewithhateoas.model.User;
import com.quetzalcoatl.springbootcoursewithhateoas.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantVotingApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		userRepository.save(new User("user@gmail.com", "User_First", "User_Last", "{noop}password", new HashSet<>(Collections.singletonList(Role.ROLE_USER))));
		userRepository.save(new User("admin@javaops.ru", "Admin_First", "Admin_Last", "{noop}admin", new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN))));
		System.out.println(userRepository.findByLastNameContainingIgnoreCase("last"));
	}
}
