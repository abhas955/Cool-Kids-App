package com.coolkids.coolKidsApp.controllers;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateEventRequest {
    private final String Id;
    private final String eventStartDateTime;
    private final String eventEndDateTime;
    private final String eventCreatedDate;
    private final String eventUpdatedDate;
    private final String eventType;
    private final String maxAttendance;
    private final String currentRSVPS;
    private final String eventAddress;
    private final String eventDescription;
    private final String contactPersonName;
    private final String contactPersonPhoneNumber;
    private final String contactPersonEmail;
    private final String userRole; //TODO: Do we need this for adminValidation?
}
