package com.coolkids.coolKidsApp.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private LocalDateTime time = LocalDateTime.now();
    private String title;
    private String location;
    private String desc;
    private String img;
    @JsonProperty("event_url")
    private String eventUrl;
    private String eventStartDateTime;
    private String eventEndDateTime;
    private String eventCreatedDate;
    private String eventUpdatedDate;
    private String eventTitle;
    private String eventType;
    //private String eventPhoto;
    private Integer maxAttendance;
    private Integer currentRSVPS;
    private String eventAddress;
    private String eventDescription;
    private String contactPersonName;
    //private String contactPersonPhoto;
    private Integer contactPersonPhoneNumber;
    private String contactPersonEmail;


}
