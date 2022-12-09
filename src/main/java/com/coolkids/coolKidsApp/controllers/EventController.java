package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.model.EventListDTO;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.services.eventServices.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EventController.BASE_URL)
@AllArgsConstructor
public class EventController {

    public static final String BASE_URL = "/api/v1/events";

    @Autowired
    EventRepository eventRepository;

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<EventListDTO> getListOfEvents(){
        return new ResponseEntity<EventListDTO>(
                new EventListDTO(eventService.getAllEvents()), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        return new ResponseEntity<EventDTO>(
                eventService.getEventById(id), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<EventDTO> getEventByTitle(@PathVariable String title){
        return new ResponseEntity<EventDTO>(eventService.getEventByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/start/{start}")
    public ResponseEntity<EventDTO> getEventByStartDateTime(@PathVariable String start){
        return new ResponseEntity<EventDTO>(
                eventService.getEventByStartDateTime(start), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<EventDTO> getEventByType(@PathVariable String type){
        return new ResponseEntity<EventDTO>(
                eventService.getEventByType(type), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EventDTO> createNewEvent(@RequestBody EventDTO eventDTO){
        return new ResponseEntity<EventDTO>(eventService.createNewEvent(eventDTO), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO){
        return new ResponseEntity<EventDTO>(eventService.saveEventByDTO(id, eventDTO), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EventDTO> patchEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO){
        return new ResponseEntity<EventDTO>(eventService.patchEvent(id, eventDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEvent(@PathVariable Long id){
        eventService.deleteEventById(id);
    }

    //Todo: get current number of rsvps
    @GetMapping("/rsvps/{title}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Integer> rsvpdUserCount(@PathVariable String title){
        Event event = eventRepository.findEventByEventTitle(title).orElseThrow(() -> new UsernameNotFoundException("Event not found"));
        return new ResponseEntity<Integer>(event.getRsvps(), HttpStatus.OK);
    }

}
