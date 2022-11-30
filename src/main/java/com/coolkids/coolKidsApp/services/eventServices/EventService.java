package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    EventDTO getEventById(String id);

   EventDTO getEventByTitle(String title);

    EventDTO getEventByTime(String time);

    EventDTO createNewEvent(EventDTO eventDTO);

    EventDTO saveEventByDTO(String id, EventDTO eventDTO);

    EventDTO patchEvent(String id, EventDTO eventDTO);

    //By I've RSVP'd

    //By I've created

    //Delete
    void deleteEventById(String idToDelete);

}
