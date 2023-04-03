package com.example.jwt.api;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jwt.api.entity.User;
import com.example.jwt.api.repository.UserRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct     //used on a method that needs to be executed after dependency injection is done to perform any initialization. 
	public void initUsers() {
		List<User> users=new ArrayList<User>();
		users.add(new User(101, "anirban", "password", "Anirban@gmail.com"));
				users.add(new User(102, "user1", "pwd1", "user1@gmail.com"));
				users.add(new User(103, "user2", "pwd2", "user2@gmail.com"));
				users.add(new User(104, "user3", "pwd3", "user3@gmail.com"));
        repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
