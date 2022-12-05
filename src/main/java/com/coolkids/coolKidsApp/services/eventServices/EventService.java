package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

   EventDTO getEventByTitle(String title);

    EventDTO getEventByTime(LocalDateTime time);

    EventDTO createNewEvent(EventDTO eventDTO);

    EventDTO saveEventByDTO(Long id, EventDTO eventDTO);

    EventDTO patchEvent(Long id, EventDTO eventDTO);

    //By I've RSVP'd

    //By I've created

    //Delete
    void deleteEventById(Long idToDelete);

}
