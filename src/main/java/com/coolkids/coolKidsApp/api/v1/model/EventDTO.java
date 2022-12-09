package com.coolkids.coolKidsApp.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import jdk.javadoc.internal.doclets.formats.html.markup.Text;
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private String eventStartDateTime;
    private String eventEndDateTime;
    private String eventCreatedDate;
    private String eventUpdatedDate;
    private String eventTitle;
    private String eventType;
    private String eventPhotoUrl;
    private Integer maxAttendance;
    private Integer currentRSVPS;
    private String eventAddress;
    private String eventDescription;
    private String contactPersonName;
    //private String contactPersonPhoto;
    private String contactPersonPhoneNumber;
    private String contactPersonEmail;

    @JsonProperty("event_url")
    private String eventUrl;
}
