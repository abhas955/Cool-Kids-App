package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Role;
import com.coolkids.coolKidsApp.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(UserRole name);
}
