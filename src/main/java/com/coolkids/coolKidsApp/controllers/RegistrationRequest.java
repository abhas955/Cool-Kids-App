package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.domain.Event;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class RegistrationRequest {
    @NotBlank
    @Size(min = 6, max = 20)
    private final String username;
    private final String firstName;
    private final String lastName;

    @NotBlank
    @Size(max = 50)
    @Email
    private final String email;

    private final String phoneNumber;
    private final String birthdate;
    private final String address;
    @NotBlank
    @Size(min = 6, max = 40)
    private final String password;
    private Set<String> roles;


}
