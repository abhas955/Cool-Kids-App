package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.domain.Event;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String birthdate;
    private final String address;
    private final Set<Event> events;

}
