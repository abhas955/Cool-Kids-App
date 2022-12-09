package com.coolkids.coolKidsApp;

import com.mongodb.client.model.changestream.TruncatedArray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class CoolKidsAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoolKidsAppApplication.class, args);
	}

}
