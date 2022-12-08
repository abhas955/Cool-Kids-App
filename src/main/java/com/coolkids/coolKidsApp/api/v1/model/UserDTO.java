package com.coolkids.coolKidsApp.api.v1.model;

import com.coolkids.coolKidsApp.domain.UserRole;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole userRole;
    private String birthdate;
    private String address;
    private String phoneNumber;
    private LocalDate accountCreatedDate;
    private LocalDate accountUpdatedDate;
    private String profilePic;


}
