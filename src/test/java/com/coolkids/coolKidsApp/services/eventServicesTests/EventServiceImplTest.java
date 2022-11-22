package com.coolkids.coolKidsApp.services.eventServicesTests;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.services.eventServices.EventService;
import com.coolkids.coolKidsApp.services.eventServices.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EventServiceImplTest {
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
    public void createEvent() throws Exception {

        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventTitle("Test Event");

        Event savedEvent = new Event();
        savedEvent.setEventTitle(eventDTO.getEventTitle());

        when(eventRepository.insert(any(Event.class))).thenReturn(savedEvent);

        //when
        EventDTO savedDto = eventService.createEvent(eventDTO);

        //then
        assertEquals(eventDTO.getEventTitle(), savedDto.getEventTitle());
        //assertEquals("/api/v1/events/1", savedDto.getEventUrl()); //Todo: /{id} or /1? Right now it is returning null.
    }
}
