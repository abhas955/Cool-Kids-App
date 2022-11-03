package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.model.EventListDTO;

import com.coolkids.coolKidsApp.api.v1.model.UserListDTO;
import com.coolkids.coolKidsApp.api.v1.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/events") //Getmapping vs Postmapping here?
    public ResponseEntity<EventListDTO> getAllEvents(){
        return new ResponseEntity<EventListDTO>(
                new EventListDTO(eventService.getAllEvents()), HttpStatus.OK);
    }

}
