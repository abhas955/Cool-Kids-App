package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface EventRepository extends MongoRepository<Event, String> {

    //Method in Udemy course. Video #193 @ 11:00
    //Optional<Event> findEventById(String id);

    //How it's done for findUserByLastName
    Event findEventById(String id);
}
