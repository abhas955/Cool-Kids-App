package com.coolkids.coolKidsApp;

import com.coolkids.coolKidsApp.UserRepository;
import com.mongodb.client.model.changestream.TruncatedArray;

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
		repository.save(new User("1", "Jim", "Smith", "Email@email.com", true, "Token", "111-111-1111", true, "http://stackoverflow.com", "Password", "Password Reset", 1/1/1900, "Admin", "123 MyAddress", "Admin", "StaffPosition", "Read/Write/Delete", 1/1/1900, 1/2/1900));

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
