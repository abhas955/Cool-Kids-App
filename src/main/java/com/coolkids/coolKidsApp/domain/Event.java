package com.coolkids.coolKidsApp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private LocalDate eventCreatedDate;
    private LocalDate eventUpdatedDate;
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

    //Using boxing object. Recommended by Hibernate team since primitive can't be null.
    //Note this is for h2 db
    //@Lob He uses this in the example
    //private Byte[] image;

    public Event(LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime,
                 LocalDate eventCreatedDate, LocalDate eventUpdatedDate, String eventType,
                 Integer maxAttendance, Integer currentRSVPS, String eventAddress,
                 String eventDescription, String contactPersonName, Integer contactPersonPhoneNumber,
                 String contactPersonEmail) {
        //this.id = id;
        this.eventStartDateTime = eventStartDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.eventCreatedDate = eventCreatedDate;
        this.eventUpdatedDate = eventUpdatedDate;
        this.eventType = eventType;
        this.maxAttendance = maxAttendance;
        this.currentRSVPS = currentRSVPS;
        this.eventAddress = eventAddress;
        this.eventDescription = eventDescription;
        this.contactPersonName = contactPersonName;
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
        this.contactPersonEmail = contactPersonEmail;
        //Todo: Add this.user and user details (inc. user role) instead of all the contact persons?
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public LocalDate getEventCreatedDate() {
        return eventCreatedDate;
    }

    public LocalDate getEventUpdatedDate() {
        return eventUpdatedDate;
    }

    public String getEventType() {
        return eventType;
    }

    public Integer getMaxAttendance() {
        return maxAttendance;
    }

    public Integer getCurrentRSVPS() {
        return currentRSVPS;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public Integer getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }
}
