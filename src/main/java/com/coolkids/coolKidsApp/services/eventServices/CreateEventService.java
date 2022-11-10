package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.controllers.CreateEventRequest;
import com.coolkids.coolKidsApp.domain.Event;
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
                        request.getId(),
                        request.getEventStartDateTime(),
                        request.getEventEndDateTime(),
                        request.getEventCreatedDate(),
                        request.getEventUpdatedDate(),
                        request.getEventType(),
                        request.getMaxAttendance(),
                        request.getCurrentRSVPS(),
                        request.getEventAddress(),
                        request.getEventDescription(),
                        request.getContactPersonName(),
                        request.getContactPersonPhoneNumber(),
                        request.getContactPersonEmail()
                        //UserRole.USER TODO: do we need this for adminValidation?
                )
        );
    }
}
