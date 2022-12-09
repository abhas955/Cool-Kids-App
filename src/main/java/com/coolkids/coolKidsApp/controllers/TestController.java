package com.coolkids.coolKidsApp.controllers;


import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.api.v1.mapper.UserMapper;

import com.coolkids.coolKidsApp.api.v1.model.UserDTO;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.domain.User;
import com.coolkids.coolKidsApp.payload.response.MessageResponse;
import com.coolkids.coolKidsApp.payload.response.UserInfoResponse;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.repository.RoleRepository;
import com.coolkids.coolKidsApp.repository.UserRepository;
import com.coolkids.coolKidsApp.security.services.UserDetailsImpl;
import com.coolkids.coolKidsApp.security.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {
	public static final String BASE_URL = "/api/test/users";


	private final UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserDetailsServiceImpl userDetailsService;


	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	//Todo: return user in session
	//Todo: User profile
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public ResponseEntity<UserDTO> userProfile(Authentication authentication) {
		String insessionUserName = authentication.getName();
		User userInSession = userRepository.findByUsername(insessionUserName).
				orElseThrow(() -> new UsernameNotFoundException("No user logged in!"));
		return new ResponseEntity<UserDTO>(userMapper.userToUserDTO(userInSession), HttpStatus.OK);

	}




	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}


    //Todo: add a profile picture (put request ) (not sure if this will be needed as we have the patch request that can also perform this task)


    //Todo: sign up for an event/RSVP
	@PostMapping("/addEvent/{eventTitle}")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public ResponseEntity<?> addEventbyTitle(@PathVariable String eventTitle, Authentication authentication){


		String name = authentication.getName();
		User user1 = (User) userRepository.findByUsername(name).
				orElseThrow(() -> new UsernameNotFoundException("User not found: "));
//				map(user -> {


					Event event = eventRepository.findEventByEventTitle(eventTitle).
							orElseThrow(() -> new UsernameNotFoundException("Event not found with title: "+eventTitle));

					if(!event.getUserSetRsvps().contains(user1)) {

						user1.addEvent(event);
						userRepository.save(user1);
						return ResponseEntity.ok(new MessageResponse("Event rsvp'd successfully!"));
					}
					else
						return ResponseEntity.ok(new MessageResponse("User aready rsvp'd for this event"));







	}

	//Todo: patch user
	@PatchMapping({"/patchUser"})
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<UserDTO> patchUser(Authentication authentication, @RequestBody UserDTO userDTO){
		String username = authentication.getName();
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not in session"));
		Long id = user.getId();
		return new ResponseEntity<UserDTO>(userDetailsService.patchUser(id, userDTO),HttpStatus.OK);
	}

	//Todo: remove event/unrsvp
	@PostMapping("/removeEvent")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public ResponseEntity<?> removeEventByTitle(@RequestBody String eventTitle, Authentication authentication){


		String name = authentication.getName();
		User user1 = (User) userRepository.findByUsername(name).
				map(user -> {
					Event event = eventRepository.findEventByEventTitle(eventTitle).
							orElseThrow(() -> new UsernameNotFoundException("Event not found with title: "+eventTitle));
					if(user.getEventRsvps().contains(event)){
						user.removeEvent(event.getId());
						userRepository.save(user);
					}


					return user;
				}).
				orElseThrow(() -> new UsernameNotFoundException("User not found: "));

		return ResponseEntity.ok(new MessageResponse("Event removed successfully!"));


	}



    //Todo: get number of events that a user signed up for
	@GetMapping("/eventsRsvpd")
	public ResponseEntity<Integer> eventsRsvpd(Authentication authentication){
		User user = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not in session"));
		return new ResponseEntity<Integer>(user.getEventsRsvpd(),HttpStatus.OK);
	}


	
	@PutMapping({"/user/{id}"})
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userDetailsServiceImpl.saveUserByDTO(id, userDTO), HttpStatus.OK);
	}







}
