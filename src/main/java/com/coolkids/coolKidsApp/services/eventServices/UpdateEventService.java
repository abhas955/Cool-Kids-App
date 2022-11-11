package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.controllers.UpdateEventRequest;
import com.coolkids.coolKidsApp.domain.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateEventService {

    private final EventServiceImpl eventServiceImpl;

    public String updateEvent(String id, UpdateEventRequest request) {
        return eventServiceImpl.updateEvent(
                new Event(
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
