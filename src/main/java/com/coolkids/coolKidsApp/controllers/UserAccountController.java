package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.api.v1.model.UserDTO;
import com.coolkids.coolKidsApp.api.v1.model.UserListDTO;
import com.coolkids.coolKidsApp.domain.User;
import com.coolkids.coolKidsApp.repository.UserRepository;

import com.coolkids.coolKidsApp.services.userServices.RegistrationService;
import com.coolkids.coolKidsApp.services.userServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class UserAccountController {
    private RegistrationService registrationService;
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/login")
    public String listUsers(Model model){
        Optional<User> user = userRepository.findByEmail("email");

        model.addAttribute("firstName", user);
        return "successfully logged in";
    }

    @GetMapping("")
    public ResponseEntity<UserListDTO> getAllUsers(){
        return new ResponseEntity<UserListDTO>(
                new UserListDTO(userService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<UserDTO> getUserByLastName(@PathVariable String lastName){
        return new ResponseEntity<UserDTO>(
                userService.getUserByLastName(lastName),HttpStatus.OK);
    }

    //Todo: create user endpoint


    //Todo: delete user endpoint (by id)


    //Todo: get a user by id endpoint


    //Todo: update a user (patch request)


    //Todo: replace a user (put request ) (not sure if this will be needed)


    //Todo: sign up for an event


    //Todo: get events that a user signed up for









}
