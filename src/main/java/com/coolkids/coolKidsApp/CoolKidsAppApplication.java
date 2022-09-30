package com.coolkids.coolKidsApp;

import com.coolkids.coolKidsApp.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CoolKidsAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(CoolKidsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		//Save a couple of users
		repository.save(new User("Jim", "Smith"));
		repository.save(new User("Bob", "West"));

		//fetch all users
		System.out.println("Users found with findAll():");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		//fetch an individual user
		// fetch an individual customer
		System.out.println("User found with findByFirstName('Jim'):");
		System.out.println(repository.findByFirstName("Jim"));
		}

}
