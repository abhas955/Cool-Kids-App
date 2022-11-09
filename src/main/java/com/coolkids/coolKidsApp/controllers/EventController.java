package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.model.EventListDTO;

import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    //Todo: list all events
    //TODO: Need to be logged in
    @GetMapping("/events")
    public ResponseEntity<EventListDTO> getAllEvents(){
        return new ResponseEntity<EventListDTO>(
                new EventListDTO(eventService.getAllEvents()), HttpStatus.OK);
    }

    //Todo: get an event by id
    @GetMapping("/events/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable String id){
        return new ResponseEntity<EventDTO>(
                eventService.findEventById(id), HttpStatus.OK);
    }

    //Todo: create event
    //Todo: Need to be logged in as an admin
    //Todo: Create a new event document or part of document?
    //Todo: Insert the document into the database
    //Todo: Let User Know if successful or fail
    //@GetMapping("/event/new")
    //public ResponseEntity<EventDTO> createEvent(){
      //  return new ResponseEntity<EventDTO>(
                //new EventDTO(eventService.createEvent(Event event)), HttpStatus.OK);
    //}


    //Todo: delete event
    



    //Todo: update an event (patch)


    //Todo: cancel an event


    //Todo: get users signed up for an event
}
