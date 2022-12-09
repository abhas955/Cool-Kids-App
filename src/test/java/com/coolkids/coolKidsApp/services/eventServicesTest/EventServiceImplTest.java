package com.coolkids.coolKidsApp.services.eventServicesTest;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.controllers.EventController;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.services.eventServices.EventService;
import com.coolkids.coolKidsApp.services.eventServices.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EventServiceImplTest {

    private final Long ID = 0000L;
    private final String EVENT_START = "0000-00-00";
    private final String EVENT_END = "0000-00-00";
    private final String EVENT_CREATED = "0000-00-00";
    private final String EVENT_UPDATED = "0000-00-00";
    private final String TITLE = "Test Event";
    private final String TYPE = "Party";
    //private final String EVENT_PHOTO = "";
    private final Integer MAX_ATTENDANCE = 100;
    private final Integer RSVPS  = 50;
    private final String EVENT_ADDRESS = "123 Event Way";
    private final String EVENT_DESCRIPTION = "This is a test event.";
    private final String CONTACT_NAME = "John Doe";
    //private final String CONTACT_PHOTO = "";
    private final String CONTACT_PHONE_NUMBER = "1234567890";
    private final String CONTACT_EMAIL = "jdoe@email.com";

    @Mock
    EventRepository eventRepository;
    EventMapper eventMapper = EventMapper.INSTANCE;
    EventService eventService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this); //In example initMocks is used, but is deprecated. This is supposed to be the new method.

        eventService = new EventServiceImpl(eventMapper, eventRepository);

    }

    @Test
    public void getAllEvents() throws Exception {
        //given
        Event event1 = new Event();
        event1.setId(0000L);
        event1.setEventTitle("Serv Impl getAllEvents Test Event 1");

        Event event2 = new Event();
        event2.setId(0001L);
        event2.setEventTitle("Serv Impl getAllEvents Test Event 2");

        when(eventRepository.findAll()).thenReturn(Arrays.asList(event1, event2));

        //when
        List<EventDTO> eventDTOS = eventService.getAllEvents();

        //then
        assertEquals(2, eventDTOS.size());

    }

    @Test
    public void getEventById() throws Exception {
        //given
        Event event1 = new Event();
        event1.setId(0000L);
        event1.setEventTitle("Serv Impl getEventById Test Event 1");

        when(eventRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(event1));

        //when
        EventDTO eventDTO = eventService.getEventById(0000L);

        //then
        assertEquals("Serv Impl getEventById Test Event 1", eventDTO.getEventTitle());

    }

    @Test
    public void getEventByTitle() throws Exception {
        //given
        Event event1 = new Event();
        event1.setEventTitle("Serv Impl getEventByTitle Test Event 1");

        when(eventRepository.findByEventTitle(anyString())).thenReturn(event1);

        //when
        EventDTO eventDTO = eventService.getEventByTitle("Serv Impl getEventByTitle Test Event 1");

        //then
        assertEquals("Serv Impl getEventByTitle Test Event 1", eventDTO.getEventTitle());
    }

    @Test
    public void getEventByStartDateTime() throws Exception {
        //given
        Event event1 = new Event();
        event1.setEventStartDateTime("0000/11/22");
        event1.setEventTitle("Serv Impl getEventByStart Test Event 1");

        when(eventRepository.findByEventStartDateTime(anyString())).thenReturn(event1);

        //when
        EventDTO eventDTO = eventService.getEventByStartDateTime("0000/11/22");

        //then
        assertEquals("0000/11/22", eventDTO.getEventStartDateTime());
    }

    @Test
    public void getEventByType() throws Exception {
        //given
        Event event1 = new Event();
        event1.setEventType("Party");
        event1.setEventTitle("Serv Impl getEventByType Test Event 1");

        when(eventRepository.findByEventType(anyString())).thenReturn(event1);

        //when
        EventDTO eventDTO = eventService.getEventByType("Serv Impl getEventByType Test Event 1");

        //then
        assertEquals("Party", eventDTO.getEventType());
    }

    @Test
    public void createEvent() throws Exception {

        //given
        EventDTO eventDTO = new EventDTO();


        eventDTO.setEventStartDateTime(EVENT_START);
        eventDTO.setEventEndDateTime(EVENT_END);
        eventDTO.setEventCreatedDate(EVENT_CREATED);
        eventDTO.setEventUpdatedDate(EVENT_UPDATED);
        eventDTO.setEventTitle(TITLE);
        eventDTO.setEventType(TYPE);
        //eventDTO.setEventPhoto(EVENT_PHOTO);
        eventDTO.setMaxAttendance(MAX_ATTENDANCE);
        eventDTO.setCurrentRSVPS(RSVPS);
        eventDTO.setEventAddress(EVENT_ADDRESS);
        eventDTO.setEventDescription(EVENT_DESCRIPTION);
        eventDTO.setContactPersonName(CONTACT_NAME);
        //eventDTO.setContactPhoto(CONTACT_PHOTO);
        eventDTO.setContactPersonPhoneNumber(CONTACT_PHONE_NUMBER);
        eventDTO.setContactPersonEmail(CONTACT_EMAIL);


        Event savedEvent = new Event();

        savedEvent.setEventStartDateTime(eventDTO.getEventStartDateTime());
        savedEvent.setEventEndDateTime(eventDTO.getEventEndDateTime());
        savedEvent.setEventCreatedDate(eventDTO.getEventCreatedDate());
        savedEvent.setEventUpdatedDate(eventDTO.getEventUpdatedDate());
        savedEvent.setEventTitle(eventDTO.getEventTitle());
        savedEvent.setEventType(eventDTO.getEventType());
        //savedEvent.setEventPhoto(eventDTO.getEventPhoto());
        savedEvent.setMaxAttendance(eventDTO.getMaxAttendance());
        savedEvent.setCurrentRSVPS(eventDTO.getCurrentRSVPS());
        savedEvent.setEventAddress(eventDTO.getEventAddress());
        savedEvent.setEventDescription(eventDTO.getEventDescription());
        savedEvent.setContactPersonName(eventDTO.getContactPersonName());
        //savedEvent.setContactPhoto(eventDTO.getContactPhoto());
        savedEvent.setContactPersonPhoneNumber(eventDTO.getContactPersonPhoneNumber());
        savedEvent.setContactPersonEmail(eventDTO.getContactPersonEmail());
        savedEvent.setId(ID);

        when(eventRepository.save(any(Event.class))).thenReturn(savedEvent);

        //when
        EventDTO savedDto = eventService.createNewEvent(eventDTO);

        //then
        assertEquals(eventDTO.getEventStartDateTime(), savedDto.getEventStartDateTime());
        assertEquals(eventDTO.getEventEndDateTime(), savedDto.getEventEndDateTime());
        assertEquals(eventDTO.getEventCreatedDate(), savedDto.getEventCreatedDate());
        assertEquals(eventDTO.getEventUpdatedDate(), savedDto.getEventUpdatedDate());
        assertEquals(eventDTO.getEventTitle(), savedDto.getEventTitle());
        assertEquals(eventDTO.getEventType(), savedDto.getEventType());
        //assertEquals(eventDTO.getEventPhoto(), savedDto.getEventPhoto());
        assertEquals(eventDTO.getMaxAttendance(), savedDto.getMaxAttendance());
        assertEquals(eventDTO.getCurrentRSVPS(), savedDto.getCurrentRSVPS());
        assertEquals(eventDTO.getEventAddress(), savedDto.getEventAddress());
        assertEquals(eventDTO.getEventDescription(), savedDto.getEventDescription());
        assertEquals(eventDTO.getContactPersonName(), savedDto.getContactPersonName());
        //assertEquals(eventDTO.getContactPhoto(), savedDto.getContactPhoto());
        assertEquals(eventDTO.getContactPersonPhoneNumber(), savedDto.getContactPersonPhoneNumber());
        assertEquals(eventDTO.getContactPersonEmail(), savedDto.getContactPersonEmail());
        assertEquals(EventController.BASE_URL + "/0", savedDto.getEventUrl());
    }

    @Test
    public void saveEventByDTO() throws Exception {

        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventType(TYPE);

        Event savedEvent = new Event();
        savedEvent.setEventType(eventDTO.getEventType());
        savedEvent.setId(ID);

        when(eventRepository.save(any(Event.class))).thenReturn(savedEvent);

        //when
        EventDTO savedDTO = eventService.saveEventByDTO(ID, eventDTO);

        //then
        assertEquals(eventDTO.getEventType(), savedDTO.getEventType());
        assertEquals(EventController.BASE_URL + "/0", savedDTO.getEventUrl());
    }

    @Test
    public void deleteEventById() throws Exception {
        Long id = 0000L;

        eventRepository.deleteById(id);

        verify(eventRepository, times(1)).deleteById(anyLong());
    }
}
