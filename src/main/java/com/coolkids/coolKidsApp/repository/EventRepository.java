package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional(readOnly = true)
public interface EventRepository extends MongoRepository<Event, String> {

    Event findByTitle(String title);

    Event findByTime(LocalDateTime time);

    //Event findByEventType(String type);

}
