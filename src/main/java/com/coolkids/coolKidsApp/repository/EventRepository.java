package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EventRepository extends MongoRepository<Event, String> {

    Event findByEventTitle(String title);

    Event findByEventStartDateTime(String eventStartDateTime);

    Event findByEventType(String type);
}
