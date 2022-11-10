package com.coolkids.coolKidsApp.controllers;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateEventRequest {
    //private final String Id;
    private final LocalDateTime eventStartDateTime;
    private final LocalDateTime eventEndDateTime;
    private final LocalDate eventCreatedDate;
    private final LocalDate eventUpdatedDate;
    private final String eventType;
    private final Integer maxAttendance;
    private final Integer currentRSVPS;
    private final String eventAddress;
    private final String eventDescription;
    private final String contactPersonName;
    private final Integer contactPersonPhoneNumber;
    private final String contactPersonEmail;
    private final String userRole; //TODO: Do we need this for adminValidation?
}
