package com.coolkids.coolKidsApp.repository;

import java.util.List;
import java.util.Optional;

import com.coolkids.coolKidsApp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
//    public User findByEmail(String email);


    public User findByFirstName(String firstName);
     User findUserByLastName(String lastName);

     List<User> findByLastName(String lastName);

     User findUserById(String id);

}
