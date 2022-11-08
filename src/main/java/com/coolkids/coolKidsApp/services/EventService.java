package com.coolkids.coolKidsApp.services;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.domain.Event;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    String createEvent(Event event);
}
