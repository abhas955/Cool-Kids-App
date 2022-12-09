package com.coolkids.coolKidsApp.api.v1.model;

import com.coolkids.coolKidsApp.domain.Role;
import com.coolkids.coolKidsApp.domain.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Role> roles;
    private String birthdate;
    private String address;
    private String phoneNumber;
    private LocalDate accountCreatedDate;
    private LocalDate accountUpdatedDate;
    private String profilePic;

    @JsonProperty("user_url")
    private String userUrl;

}
