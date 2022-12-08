package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
//@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findUserByEmail(String email);

    User findByFirstName(String firstName);

    User findUserByLastName(String lastName);

    List<User> findByLastName(String lastName);

    User findUserById(Long id);
    Optional<User> findByUsername(String username);
    User findByusername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
