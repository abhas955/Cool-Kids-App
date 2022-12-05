package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional(readOnly = true)
public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByTitle(String title);

    Event findByTime(LocalDateTime time);

    //Event findByEventType(String type);


    Event findByEventType(String type);

    Boolean existsByEventTitle(String username);

}
