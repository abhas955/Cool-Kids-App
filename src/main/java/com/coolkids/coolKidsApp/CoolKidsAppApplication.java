package com.coolkids.coolKidsApp;

import com.mongodb.client.model.changestream.TruncatedArray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CoolKidsAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoolKidsAppApplication.class, args);
	}

}
