package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.model.User;
import com.coolkids.coolKidsApp.repository.UserRepository;
import com.coolkids.coolKidsApp.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserAccountController {
    private RegistrationService registrationService;
    private final UserRepository userRepository;

    @PostMapping("api/v1/registration")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("api/v1/login")
    public String listUsers(Model model){
        List<User> listUsers = userRepository.findAll();

        model.addAttribute("listUsers", listUsers);
        return "successfully logged in";
    }




}
