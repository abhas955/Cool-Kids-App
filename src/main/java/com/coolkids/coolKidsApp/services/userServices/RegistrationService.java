//package com.coolkids.coolKidsApp.services.userServices;
//
//import com.coolkids.coolKidsApp.controllers.RegistrationRequest;
//import com.coolkids.coolKidsApp.domain.User;
//import com.coolkids.coolKidsApp.domain.UserRole;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class RegistrationService {
//
//    private final UserServiceImpl userServiceImpl;
//    private EmailValidator emailValidator;
//
//    public String register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.test(request.getEmail());
//        if(!isValidEmail) {
//            throw new IllegalStateException("Invalid Email");
//        }
//
//
//        return userServiceImpl.signUpUser(
//                new User(
//                request.getFirstName(),
//                request.getLastName(),
//                request.getPhoneNumber(),
//                request.getEmail(),
//                request.getBirthdate(),
//                request.getAddress(),
//                request.getPassword(),
//                UserRole.USER,
//                request.getEvents()
//
//            )
//        );
//    }
//
//
//
//
//}
