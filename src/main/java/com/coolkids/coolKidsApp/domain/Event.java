package com.coolkids.coolKidsApp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    private String id;

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
    //private String contactPersonPicture;
    private Integer contactPersonPhoneNumber;
    private String contactPersonEmail;

}

