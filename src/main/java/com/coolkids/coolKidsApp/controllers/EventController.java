package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.model.EventListDTO;

import com.coolkids.coolKidsApp.services.eventServices.CreateEventService;
import com.coolkids.coolKidsApp.services.eventServices.EventService;
import com.coolkids.coolKidsApp.services.eventServices.UpdateEventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/events")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;
    private final CreateEventService createEventService;
    private final UpdateEventService updateEventService;

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

    //Todo: change String to EventDTO
    @PostMapping("/new")
    public String createNewEvent(@RequestBody CreateEventRequest request){
        return createEventService.createEvent(request);
    }
    //Todo: Show newly created event

    //Todo: delete event
    //Todo: add http status
    @DeleteMapping("/{id}/delete")
    public void deleteEventById(@PathVariable String id){
        eventService.deleteEventById(id);
    }

    //Todo: update an event (patch)
    //This controller is to return the event to update
    //Todo: Is this repetition of getEventById?
    @GetMapping("/{id}/update")
    public ResponseEntity<EventDTO> getEventByIdToUpdate(@PathVariable String id){
        //Todo: Add response status. Do I change the eventDTO?
        //if(!eventIDExists(id)) {
          // return new ResponseEntity<EventDTO>("Event Not Found", HttpStatus.BAD_REQUEST);
        //}
        //Todo: does getEventById need to be getEvent&BodyById?

        return new ResponseEntity<EventDTO>(
                eventService.getEventById(id), HttpStatus.OK);
    }

    //Todo: Update Event
    //This controller is to save the updates
    @PostMapping("/{id}/update")
    public String saveEventUpdate(@PathVariable String id, @RequestBody UpdateEventRequest request){
        return updateEventService.updateEvent(id, request);
    }

                //Todo: cancel an event

                //Todo: get users signed up for an event

}
