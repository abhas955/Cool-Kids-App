package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.domain.Event;

import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();
    EventDTO getEventById(String id);
    String createEvent(Event event);
    Void deleteEventById(String idToDelete);

    //TODO: add save Event

    //Todo: add deleteEventById

}
