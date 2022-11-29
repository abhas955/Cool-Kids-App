//package com.coolkids.coolKidsApp.controllers;
//
//import com.coolkids.coolKidsApp.api.v1.model.UserDTO;
//import com.coolkids.coolKidsApp.api.v1.model.UserListDTO;
//import com.coolkids.coolKidsApp.domain.User;
//import com.coolkids.coolKidsApp.repository.UserRepository;
//
//import com.coolkids.coolKidsApp.security.PasswordEncoder;
//import com.coolkids.coolKidsApp.services.userServices.RegistrationService;
//import com.coolkids.coolKidsApp.services.userServices.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path = "api/v1/users")
//@AllArgsConstructor
//public class UserAccountController {
//    private RegistrationService registrationService;
//    private final UserRepository userRepository;
//    private final UserService userService;
//
//    //Todo: create user endpoint
//
//    @PostMapping("/register")
//    public String register(@RequestBody RegistrationRequest request){
//        return registrationService.register(request);
//    }
//
//    @GetMapping("/login")
//    public String listUsers(Model model){
//        Optional<User> user = userRepository.findByEmail("email");
//
//        model.addAttribute("firstName", user);
//        return "successfully logged in";
//    }
//
//    @GetMapping("")
//    public ResponseEntity<UserListDTO> getAllUsers(){
//        return new ResponseEntity<UserListDTO>(
//                new UserListDTO(userService.getAllUsers()), HttpStatus.OK);
//    }
//
//    @GetMapping("/{lastName}")
//    public ResponseEntity<UserDTO> getUserByLastName(@PathVariable String lastName){
//        return new ResponseEntity<UserDTO>(
//                userService.getUserByLastName(lastName),HttpStatus.OK);
//    }
//
//    @GetMapping("/checkPassword/{password}")
//    public boolean checkPassword(@RequestParam String hash, @PathVariable String password) {
//        PasswordEncoder passwordEncoder = new PasswordEncoder();
//        return passwordEncoder.bCryptPasswordEncoder().matches(password, hash);
//    }
//
//    //Todo: get a user by id endpoint
//    @GetMapping("/id/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
//        return new ResponseEntity<UserDTO>(
//                userService.getUserById(id), HttpStatus.OK);
//    }
//
//    //Todo: delete user endpoint (by id)
//    //@DeleteMapping("/deleteUser/{id}")
//
//
//
//
//
//    //Todo: update a user (patch request)
//
//
//    //Todo: replace a user (put request ) (not sure if this will be needed)
//
//
//    //Todo: sign up for an event
//
//
//    //Todo: get events that a user signed up for
//
//
//
//
//
//
//
//
//
//}
