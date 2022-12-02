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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EventServiceImplTest {
    /*
    private final String ID = "0000";
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
    private final Integer CONTACT_PHONE_NUMBER = 1234567890;
    private final String CONTACT_EMAIL = "jdoe@email.com";
     */

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
        event1.setId("0000");
        event1.setTitle("Serv Impl getAllEvents Test Event 1");

        Event event2 = new Event();
        event2.setId("0001");
        event2.setTitle("Serv Impl getAllEvents Test Event 2");

        when(eventRepository.findAll()).thenReturn(Arrays.asList(event1, event2));

        //when
        List<EventDTO> eventDTOS = eventService.getAllEvents();

        //then
        assertEquals(2, eventDTOS.size());

    }

    @Test
    public void getEventById() throws Exception {
        //given
        Event event = new Event();
        event.setId("0000");
        event.setTitle("Serv Impl getEventById Test Event 1");

        when(eventRepository.findById(anyString())).thenReturn(java.util.Optional.ofNullable(event));

        //when
        EventDTO eventDTO = eventService.getEventById("0000");

        //then
        assertEquals("Serv Impl getEventById Test Event 1", eventDTO.getTitle());

    }

    @Test
    public void getEventByTitle() throws Exception {
        //given
        Event event = new Event();
        event.setTitle("Serv Impl getEventByTitle Test Event 1");

        when(eventRepository.findByTitle(anyString())).thenReturn(event);

        //when
        EventDTO eventDTO = eventService.getEventByTitle("Serv Impl getEventByTitle Test Event 1");

        //then
        assertEquals("Serv Impl getEventByTitle Test Event 1", eventDTO.getTitle());
    }

    /*
    @Test
    public void getEventByTime() throws Exception {
        //given
        Event event = new Event();
        event.setTime(LocalDateTime.now());
        event.setTitle("Serv Impl getEventByStart Test Event 1");

        when(eventRepository.findByTime(LocalDateTime.now())).thenReturn(event);

        //when
        EventDTO eventDTO = eventService.getEventByTime(LocalDateTime.now());

        //then
        assertEquals(LocalDateTime.now(), eventDTO.getTime());
    }
     */

    /*
    @Test
    public void getEventByType() throws Exception {
        //given
        Event event1 = new Event();
        event1.setType("Party");
        event1.setTitle("Serv Impl getEventByType Test Event 1");

        when(eventRepository.findByEventType(anyString())).thenReturn(event1);

        //when
        EventDTO eventDTO = eventService.getEventByType("Serv Impl getEventByType Test Event 1");

        //then
        assertEquals("Party", eventDTO.getEventType());
    }
     */

    @Test
    public void createEvent() throws Exception {

        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId("0000");
        eventDTO.setTime(LocalDateTime.now());
        eventDTO.setTitle("Test Create Event 1");
        eventDTO.setLocation("123 Event Way, Charlotte, NC");
        eventDTO.setDesc("This is a test event.");
        eventDTO.setImg("https://coolkidscampaign.org/wp-content/uploads/2022/11/December-10th-2022-1.png");

        /*
        eventDTO.setId(ID);
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
         */


        Event savedEvent = new Event();

        savedEvent.setTime(eventDTO.getTime());
        savedEvent.setTitle(eventDTO.getTitle());
        savedEvent.setLocation(eventDTO.getLocation());
        savedEvent.setDesc(eventDTO.getDesc());
        savedEvent.setImg(eventDTO.getImg());

        /*
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
         */

        when(eventRepository.save(any(Event.class))).thenReturn(savedEvent);

        //when
        EventDTO savedDto = eventService.createNewEvent(eventDTO);

        //then
        assertEquals(eventDTO.getTime(), savedDto.getTime());
        assertEquals(eventDTO.getTitle(), savedDto.getTitle());
        assertEquals(eventDTO.getLocation(), savedDto.getLocation());
        assertEquals(eventDTO.getDesc(), savedDto.getDesc());
        assertEquals(eventDTO.getImg(), savedDto.getImg());

        /*
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
        assertEquals(EventController.BASE_URL + "/0000", savedDto.getEventUrl());
         */
    }

    @Test
    public void saveEventByDTO() throws Exception {

        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setTitle("Test Save Event By DTO 1");

        Event savedEvent = new Event();
        savedEvent.setTitle(eventDTO.getTitle());
        savedEvent.setId("0000");

        when(eventRepository.save(any(Event.class))).thenReturn(savedEvent);

        //when
        EventDTO savedDTO = eventService.saveEventByDTO("0000", eventDTO);

        //then
        assertEquals(eventDTO.getTitle(), savedDTO.getTitle());
        assertEquals(EventController.BASE_URL + "/0000", savedDTO.getEventUrl());
    }

    @Test
    public void deleteEventById() throws Exception {
        String id = "0000";

        eventRepository.deleteById(id);

        verify(eventRepository, times(1)).deleteById(anyString());
    }
}
