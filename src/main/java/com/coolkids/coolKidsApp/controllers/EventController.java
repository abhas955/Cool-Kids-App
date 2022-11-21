package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.model.EventListDTO;

import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.services.eventServices.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/events")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;
    private final EventRepository eventRepository;

    //Todo: list all events
    //TODO: Need to be logged in
    @GetMapping("")
    public ResponseEntity<EventListDTO> getAllEvents(){
        return new ResponseEntity<EventListDTO>(
                new EventListDTO(eventService.getAllEvents()), HttpStatus.OK);
    }

    //Todo: get an event by id
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable String id){
        return new ResponseEntity<EventDTO>(
            eventService.getEventById(id), HttpStatus.OK);
    }

    //Todo: Need to be logged in as an admin
    @PostMapping("/new")
    public ResponseEntity createEvent(@RequestBody Event event) throws URISyntaxException {
        Event newEvent = eventRepository.insert(event);
        return ResponseEntity.created(new URI("/" + newEvent.getId())).body(newEvent);
    }

    //Todo: delete event
    @DeleteMapping("/{id}/delete")
    public void deleteEventById(@PathVariable String id){
        eventService.deleteEventById(id);
    }

    //Todo: update an event (patch)

                //Todo: cancel an event

                //Todo: get users signed up for an event

}
