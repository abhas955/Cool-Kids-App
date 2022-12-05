package com.coolkids.coolKidsApp.controllers.v1;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.controllers.EventController;
import com.coolkids.coolKidsApp.controllers.RestResponseEntityExceptionHandler;
import com.coolkids.coolKidsApp.services.eventServices.EventService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EventControllerTest extends AbstractRestControllerTest {

    @Mock
    EventService eventService;

    @InjectMocks
    EventController eventController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(eventController)
            .setControllerAdvice(new RestResponseEntityExceptionHandler())
            .build();
    }

    @Test
    public void testListEvents() throws Exception {
        //given
        EventDTO eventDTO1 = new EventDTO();
        eventDTO1.setEventTitle("Contr listEvents Test Event 1");

        eventDTO1.setEventUrl(EventController.BASE_URL + "/1");

        EventDTO eventDTO2 = new EventDTO();
        eventDTO2.setEventTitle("Contr listEvents Test Event 2");
        eventDTO2.setEventUrl(EventController.BASE_URL + "/2");

        when(eventService.getAllEvents()).thenReturn(Arrays.asList(eventDTO1, eventDTO2));

        //when
        mockMvc.perform(get(EventController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.events", hasSize(2)));
    }

    @Test
    public void testGetEventById() throws Exception {

        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventTitle("Contr EventById Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/1");

        when(eventService.getEventById(anyLong())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eventTitle", equalTo("Contr EventById Test Event 1")));
    }

    @Test
    public void testGetEventByTitle() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventTitle("Contr EventByTitle Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/title/Contr EventByTitle Test Event 1");

        when(eventService.getEventByTitle(anyString())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/title/Contr EventByTitle Test Event 1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eventTitle", equalTo("Contr EventByTitle Test Event 1")));
    }

    @Test
    public void testGetEventByStartDateTime() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventStartDateTime("0000/11/22");
        eventDTO.setEventTitle("Contr EventByStart Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/start/00001122");

        when(eventService.getEventByStartDateTime(anyString())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/start/00001122")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eventTitle", equalTo("Contr EventByStart Test Event 1")));
    }

    @Test
    public void testGetEventByType() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventType("Party");
        eventDTO.setEventTitle("Contr EventByType Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/type/Party");

        when(eventService.getEventByType(anyString())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/type/Party")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eventTitle", equalTo("Contr EventByType Test Event 1")));
    }

    /*
    @Test
    public void createEvent() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();

        eventDTO.setEventStartDateTime("0000-00-00");
        eventDTO.setEventEndDateTime("1111-11-11");
        eventDTO.setEventCreatedDate("2222-22-22");
        eventDTO.setEventUpdatedDate("3333-33-33");
        eventDTO.setEventTitle("Test Event");
        eventDTO.setEventType("Party");
        //eventDTO.setEventPhoto();
        eventDTO.setMaxAttendance(100);
        eventDTO.setCurrentRSVPS(10);
        eventDTO.setEventAddress("123 Event Way");
        eventDTO.setEventDescription("This is a test event.");
        eventDTO.setContactPersonName("John Doe");
        //eventDTO.setContactPersonPhoto;
        eventDTO.setContactPersonEmail("jdoe@email.com");
        eventDTO.setContactPersonPhoneNumber(1112223333);


        EventDTO returnDTO = new EventDTO();

        returnDTO.setEventStartDateTime(eventDTO.getEventStartDateTime());
        returnDTO.setEventEndDateTime(eventDTO.getEventEndDateTime());
        returnDTO.setEventCreatedDate(eventDTO.getEventCreatedDate());
        returnDTO.setEventUpdatedDate(eventDTO.getEventUpdatedDate());
        returnDTO.setEventTitle(eventDTO.getEventTitle());
        returnDTO.setEventType(eventDTO.getEventType());
        //returnDTO.setEventPhoto(eventDTO.getEventPhoto());
        returnDTO.setMaxAttendance(eventDTO.getMaxAttendance());
        returnDTO.setCurrentRSVPS(eventDTO.getCurrentRSVPS());
        returnDTO.setEventAddress(eventDTO.getEventAddress());
        returnDTO.setEventDescription(eventDTO.getEventDescription());
        returnDTO.setContactPersonName(eventDTO.getContactPersonName());
        //returnDTO.setContactPersonPhoto(eventDTO.getContactPersonPhoto());
        returnDTO.setContactPersonPhoneNumber(eventDTO.getContactPersonPhoneNumber());
        returnDTO.setContactPersonEmail(eventDTO.getContactPersonEmail());

        returnDTO.setEventUrl(EventController.BASE_URL + "/1");

        //when/then
        mockMvc.perform(post(EventController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.eventStartDateTime", equalTo("0000-00-00")))
            .andExpect(jsonPath("$.eventEndDateTime", equalTo("1111-11-11")))
            .andExpect(jsonPath("$.eventCreatedDateTime", equalTo("2222-22-22")))
            .andExpect(jsonPath("$.eventUpdatedDateTime", equalTo("3333-33-33")))
            .andExpect(jsonPath("$.eventTitle", equalTo("Test Event")))
            .andExpect(jsonPath("$.eventType", equalTo("Party")))
            //.andExpect(jsonPath("$.eventPhoto", equalTo()))
            .andExpect(jsonPath("$.maxAttendence", equalTo(100)))
            .andExpect(jsonPath("$.currentRSVPS", equalTo(10)))
            .andExpect(jsonPath("$.eventAddress", equalTo("123 Event Way")))
            .andExpect(jsonPath("$.eventDescription", equalTo("This is a test event.")))
            .andExpect(jsonPath("$.contactPersonName", equalTo("John Doe")))
            //.andExpect(jsonPath("$.contactPersonPhoto"), equalTo())
            .andExpect(jsonPath("$.contactPersonPhoneNumber", equalTo(1112223333)))
            .andExpect(jsonPath("$.contactPersonEmail", equalTo("jdoe@email.com")))
            .andExpect(jsonPath("$.event_url", equalTo(EventController.BASE_URL + "/1")));
    }
    */

    @Test
    public void testUpdateEvent() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventType("Party");

        EventDTO returnDTO = new EventDTO();
        returnDTO.setEventType(eventDTO.getEventType());
        returnDTO.setEventUrl(EventController.BASE_URL + "/0000");

        when(eventService.saveEventByDTO(anyLong(), any(EventDTO.class))).thenReturn(eventDTO);
    }

    @Test
    public void testDeleteEvent() throws Exception {

        mockMvc.perform(delete(EventController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(eventService).deleteEventById(anyLong());
    }

    @Test
    public void testNotFoundException() throws Exception {

        when(eventService.getEventById(anyLong())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(EventController.BASE_URL + "/9999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
