package com.coolkids.coolKidsApp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    private String id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private String title;
    private String location;
    private String desc;
    private String img;

    @DBRef
    private Set<User> users = new HashSet<>();


    /*
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
     */

    public void setType(String party) {
    }
}

