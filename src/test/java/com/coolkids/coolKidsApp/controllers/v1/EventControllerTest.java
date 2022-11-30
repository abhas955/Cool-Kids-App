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
        eventDTO1.setTitle("Contr listEvents Test Event 1");

        eventDTO1.setEventUrl(EventController.BASE_URL + "/1");

        EventDTO eventDTO2 = new EventDTO();
        eventDTO2.setTitle("Contr listEvents Test Event 2");
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
        eventDTO.setTitle("Contr EventById Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/1");

        when(eventService.getEventById(anyString())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Contr EventById Test Event 1")));
    }

    @Test
    public void testGetEventByTitle() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setTitle("Contr EventByTitle Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/title/Contr EventByTitle Test Event 1");

        when(eventService.getEventByTitle(anyString())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/title/Contr EventByTitle Test Event 1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Contr EventByTitle Test Event 1")));
    }

    @Test
    public void testGetEventByTime() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setTime("0000/11/22");
        eventDTO.setTitle("Contr EventByStart Test Event 1");
        eventDTO.setEventUrl(EventController.BASE_URL + "/time/00001122");

        when(eventService.getEventByTime(anyString())).thenReturn(eventDTO);

        //when
        mockMvc.perform(get(EventController.BASE_URL + "/time/00001122")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Contr EventByStart Test Event 1")));
    }

    /*
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

     */

    @Test
    public void testCreateEvent() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();

        eventDTO.setTitle("Contr Test Test Event 1");

        EventDTO returnDTO = new EventDTO();
        returnDTO.setTitle(eventDTO.getTitle());
        returnDTO.setEventUrl(EventController.BASE_URL + "/0000");

        when(eventService.createNewEvent(eventDTO)).thenReturn(returnDTO);

        //when/then
        mockMvc.perform(post(EventController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.title", equalTo("Contr Test Test Event 1")))
            .andExpect(jsonPath("$.event_url", equalTo(EventController.BASE_URL + "/0000")));

    }

    @Test
    public void testUpdateEvent() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setTitle("Test Updated Event 1");

        EventDTO returnDTO = new EventDTO();
        returnDTO.setTitle(eventDTO.getTitle());
        returnDTO.setEventUrl(EventController.BASE_URL + "/0000");

        when(eventService.saveEventByDTO(anyString(), any(EventDTO.class))).thenReturn(eventDTO);
    }

    @Test
    public void testDeleteEvent() throws Exception {

        mockMvc.perform(delete(EventController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(eventService).deleteEventById(anyString());
    }

    @Test
    public void testNotFoundException() throws Exception {

        when(eventService.getEventById(anyString())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(EventController.BASE_URL + "/9999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
