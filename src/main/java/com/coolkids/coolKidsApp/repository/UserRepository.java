package com.coolkids.coolKidsApp.repository;

import java.util.List;
import java.util.Optional;

import com.coolkids.coolKidsApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    public User findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);

}
