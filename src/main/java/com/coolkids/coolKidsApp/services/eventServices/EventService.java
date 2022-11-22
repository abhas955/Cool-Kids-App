package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;

import java.util.List;

public interface EventService {

    EventDTO createEvent(EventDTO eventDTO);
    List<EventDTO> getAllEvents();
    EventDTO getEventById(String id);
    Void deleteEventById(String idToDelete);

    //TODO: add save Event

    //Todo: add deleteEventById

}
