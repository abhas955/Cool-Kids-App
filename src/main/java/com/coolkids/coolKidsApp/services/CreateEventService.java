package com.coolkids.coolKidsApp.services;

import com.coolkids.coolKidsApp.controllers.CreateEventRequest;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.domain.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateEventService {
    private final EventServiceImpl eventServiceImpl;

    //TODO: Add admin validation (like email validator)
    public String createEvent(CreateEventRequest request) {
        //boolean isAdmin = adminValidator.test(request.getUserRole());
        //if(!isAdmin) {
        //throw new IllegalAccessException("Administrator Access Required to Create Event.");
        //}

        return eventServiceImpl.createEvent(
                new Event(
                        request.getId();
                        request.eventStartDateTime();
                        request.eventEndDateTime();
                        request.eventCreatedDate();
                        request.eventUpdatedDate();
                        request.eventType();
                        request.maxAttendance();
                        request.currentRSVPS();
                        request.eventAddress();
                        request.eventDescription();
                        request.contactPersonName();
                        request.contactPersonPhoneNumber();
                        request.contactPersonEmail();
                )
        );
    }
}
