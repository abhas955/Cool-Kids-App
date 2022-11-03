package com.coolkids.coolKidsApp.repository;

import com.coolkids.coolKidsApp.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
