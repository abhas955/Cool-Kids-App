package com.coolkids.coolKidsApp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public Event(String id, LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime,
                 LocalDate eventCreatedDate, LocalDate eventUpdatedDate, String eventType,
                 Integer maxAttendance, Integer currentRSVPS, String eventAddress,
                 String eventDescription, String contactPersonName, Integer contactPersonPhoneNumber,
                 String contactPersonEmail) {
        this.id = id;
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

    public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public LocalDate getEventCreatedDate() {
        return eventCreatedDate;
    }

    public void setEventCreatedDate(LocalDate eventCreatedDate) {
        this.eventCreatedDate = eventCreatedDate;
    }

    public LocalDate getEventUpdatedDate() {
        return eventUpdatedDate;
    }

    public void setEventUpdatedDate(LocalDate eventUpdatedDate) {
        this.eventUpdatedDate = eventUpdatedDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getMaxAttendance() {
        return maxAttendance;
    }

    public void setMaxAttendance(Integer maxAttendance) {
        this.maxAttendance = maxAttendance;
    }

    public Integer getCurrentRSVPS() {
        return currentRSVPS;
    }

    public void setCurrentRSVPS(Integer currentRSVPS) {
        this.currentRSVPS = currentRSVPS;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public Integer getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(Integer contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getEventId() {
    }
}
