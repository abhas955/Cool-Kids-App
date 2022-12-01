package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.repository.RoleRepository;
import com.coolkids.coolKidsApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
	@PostMapping("/addEvent")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<?> addEventbyTitle(@RequestBody String eventTitle){
		try {
			Event event = eventRepository.findByEventTitle(eventTitle);


		}

	}




    //Todo: get events that a user signed up for
}
