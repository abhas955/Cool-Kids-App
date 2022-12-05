package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.domain.User;
import com.coolkids.coolKidsApp.payload.response.MessageResponse;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.repository.RoleRepository;
import com.coolkids.coolKidsApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	EventRepository eventRepository;



	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}


//	@GetMapping("/mod")
//	@PreAuthorize("hasRole('MODERATOR')")
//	public String moderatorAccess() {
//		return "Moderator Board.";
//	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	//Todo: update a user (patch request)



    //Todo: replace a user (put request ) (not sure if this will be needed)



    //Todo: sign up for an event
//	@PostMapping("/addEvent")
//	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
//	public ResponseEntity<?> addEventbyTitle(@RequestBody String eventTitle, String username){
//		Event event = eventRepository.findByEventTitle(eventTitle);
//
//
//
//
//		User user  = userRepository.findByusername(username);
//
//		user.getEvents().add(event);
//
//		return ResponseEntity.ok(new MessageResponse("Event rsvp'd successfully!"));
//
//	}




    //Todo: get events that a user signed up for
}
