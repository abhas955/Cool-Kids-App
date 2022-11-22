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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
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
    public void createEvent() throws Exception {
        //given
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventTitle("Test Event");

        EventDTO returnDTO = new EventDTO();
        returnDTO.setEventTitle(eventDTO.getEventTitle());
        returnDTO.setEventUrl("/api/v1/events/1"); //Todo: /1 or {id}?

        //when/then
        mockMvc.perform(post("/api/v1/events/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(eventDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.title", equalTo("Test Event")))
            .andExpect(jsonPath("$.event_url", equalTo("/api/v1/events/1")));
    }
}
