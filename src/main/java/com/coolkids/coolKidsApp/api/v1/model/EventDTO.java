package com.coolkids.coolKidsApp.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
public class EventDTO {
    private String id;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private LocalDate eventCreatedDate;
    private LocalDate eventUpdatedDate;
    private String eventTitle;
    private String eventType;
    //private String eventPhoto;
    private Integer maxAttendance;
    private Integer currentRSVPS;
    private String eventAddress;
    private String eventDescription;
    private String contactPersonName;
    //private String contactPersonPicture;
    private Integer contactPersonPhoneNumber;
    private String contactPersonEmail;

    @JsonProperty("event_url")
    private String eventUrl;
}
