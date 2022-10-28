package com.coolkids.coolKidsApp.services;

import com.coolkids.coolKidsApp.controllers.RegistrationRequest;
import com.coolkids.coolKidsApp.model.User;
import com.coolkids.coolKidsApp.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail) {
            throw new IllegalStateException("Invalid Email");
        }


        return userService.signUpUser(
                new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER

            )
        );
    }




}
