package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByEventTitle(String title);

    Event findByEventStartDateTime(String eventStartDateTime);

    Event findByEventType(String type);

    Boolean existsByEventTitle(String username);
}
