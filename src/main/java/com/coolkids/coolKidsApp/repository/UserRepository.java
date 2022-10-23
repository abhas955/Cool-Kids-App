package com.coolkids.coolKidsApp.repository;

import java.util.List;

import com.coolkids.coolKidsApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);

}
