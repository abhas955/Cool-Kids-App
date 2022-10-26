package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Spring stereotype that tells framework our intent is to turn this into a Spring framework controller.
@Controller
public class userAccountController {

    //Inject an instance of the CoolKidsAppApplication repository into the controller using the constructor below.
    private final UserRepository userRepository;

    public userAccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //What an action is invoked (gets a request) on URL /userAccount the getUserAccount method is executed.
    @RequestMapping("/userAccount")
    public String getUserAccount(Model model){

        //For this model we add the attribute "users" which will execute findAll on the UserRepository.
        model.addAttribute("users", userRepository.findAll());

        //This model (the list of users) will be returned to the view.
        return "userAccount";
    }
}
