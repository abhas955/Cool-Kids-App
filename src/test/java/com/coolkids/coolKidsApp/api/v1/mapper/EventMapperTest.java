package com.coolkids.coolKidsApp.api.v1.mapper;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.domain.Event;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class EventMapperTest {

    public static final Long ID = 00000L;
    public static final String EVENT_START = "0000-00-00";
    public static final String EVENT_END = "0000-00-00";
    public static final String EVENT_CREATED = "0000-00-00";
    public static final String EVENT_UPDATED = "0000-00-00";
    public static final String TITLE = "My test event";
    public static final String TYPE = "Party";
    //public static final String PHOTO = ""; Todo: Correct test when photos are done.
    public static final Integer MAX_ATTENDANCE = 100;
    public static final Integer RSVPS = 50;
    public static final String EVENT_ADDRESS = "123 Address Way";
    public static final String EVENT_DESCRIPTION = "This is a test event.";
    public static final String CONTACT_NAME = "John Doe";
    //public static final CONTACT_PHOTO = ; Todo: Add test once photo is solved.
    public static final String CONTACT_PHONE = "1112223333";
    public static final String EMAIL = "jdoe@email.com";

    EventMapper eventMapper = EventMapper.INSTANCE;

    @Test
    public void eventToEventDTO() throws Exception {

        //given
        Event event = new Event();

        event.setId(ID);
        event.setEventStartDateTime(EVENT_START);
        event.setEventEndDateTime(EVENT_END);
        event.setEventCreatedDate(EVENT_CREATED);
        event.setEventUpdatedDate(EVENT_UPDATED);
        event.setEventTitle(TITLE);
        event.setEventType(TYPE);
        //event.setEventPhoto(PHOTO);
        event.setMaxAttendance(MAX_ATTENDANCE);
        event.setCurrentRSVPS(RSVPS);
        event.setEventAddress(EVENT_ADDRESS);
        event.setEventDescription(EVENT_DESCRIPTION);
        event.setContactPersonName(CONTACT_NAME);
        //event.setContactPersonPicture(CONTACT_PHOTO);
        event.setContactPersonPhoneNumber(CONTACT_PHONE);
        event.setContactPersonEmail(EMAIL);

        //when
        EventDTO eventDTO = eventMapper.eventToEventDTO(event);

        //then

        assertEquals(EVENT_START, eventDTO.getEventStartDateTime());
        assertEquals(EVENT_END, eventDTO.getEventEndDateTime());
        assertEquals(EVENT_CREATED, eventDTO.getEventCreatedDate());
        assertEquals(EVENT_UPDATED, eventDTO.getEventUpdatedDate());
        assertEquals(TITLE, eventDTO.getEventTitle());
        assertEquals(TYPE, eventDTO.getEventType());
        //assertEquals(PHOTO, eventDTO.getEventPhoto());
        assertEquals(MAX_ATTENDANCE, eventDTO.getMaxAttendance());
        assertEquals(RSVPS, eventDTO.getCurrentRSVPS());
        assertEquals(EVENT_ADDRESS, eventDTO.getEventAddress());
        assertEquals(EVENT_DESCRIPTION, eventDTO.getEventDescription());
        assertEquals(CONTACT_NAME, eventDTO.getContactPersonName());
        //assertEquals(CONTACT_PHOTO, eventDTO.getContactPersonPhoto());
        assertEquals(CONTACT_PHONE, eventDTO.getContactPersonPhoneNumber());
        assertEquals(EMAIL, eventDTO.getContactPersonEmail());
    }
}
