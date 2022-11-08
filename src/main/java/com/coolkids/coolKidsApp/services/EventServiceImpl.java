package com.coolkids.coolKidsApp.services;

import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    public List<EventDTO> getAllEvents() { //TODO: The heck?
        return eventRepository.findAll() //TODO: The heck?
                .stream() //TODO: The heck?
                .map(eventMapper::eventToEventDTO) //TODO: The heck?
                .collect(Collectors.toList()); //TODO: The heck?
    }

    @Override
    public EventDTO getEventById(String id) {
        return null;
    }
}
