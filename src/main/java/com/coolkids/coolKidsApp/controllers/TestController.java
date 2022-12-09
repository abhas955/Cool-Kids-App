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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {


	private final UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserMapper userMapper;


	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	//Todo: User profile
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public ResponseEntity<UserDTO> userProfile(Authentication authentication) {
		String insessionUserName = authentication.getName();
		User userInSession = userRepository.findByUsername(insessionUserName).
				orElseThrow(() -> new UsernameNotFoundException("No user logged in!"));
		return new ResponseEntity<UserDTO>(userMapper.userToUserDTO(userInSession), HttpStatus.OK);

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


    //Todo: add a profile picture (put request ) (not sure if this will be needed)


    //Todo: sign up for an event/RSVP
	@PostMapping("/addEvent")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public ResponseEntity<?> addEventbyTitle(@RequestBody String eventTitle, Authentication authentication){


		String name = authentication.getName();
		User user1 = (User) userRepository.findByUsername(name).
				map(user -> {
					Event event = eventRepository.findEventByEventTitle(eventTitle).
							orElseThrow(() -> new UsernameNotFoundException("Event not found with title: "+eventTitle));
					user.addEvent(event);
					userRepository.save(user);

					return user;
				}).orElseThrow(() -> new UsernameNotFoundException("User not found: "));

		return ResponseEntity.ok(new MessageResponse("Event rsvp'd successfully!"));


	}

	//Todo: remove event/unrsvp

    //Todo: get events that a user signed up for
	
	@PutMapping({"/user/{id}"})
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userDetailsServiceImpl.saveUserByDTO(id, userDTO), HttpStatus.OK);
	}

	@PatchMapping({"/user/{id}"})
	public ResponseEntity<UserDTO> patchUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userDetailsServiceImpl.patchUser(id, userDTO), HttpStatus.OK);
	}

	//Todo: return user in session



}
