package com.coolkids.coolKidsApp.controllers;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
public class CreateEventRequest {
    //private final String Id;
    private final LocalDateTime eventStartDateTime;
    private final LocalDateTime eventEndDateTime;
    private final LocalDate eventCreatedDate;
    private final LocalDate eventUpdatedDate;
    private final String eventTitle;
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
