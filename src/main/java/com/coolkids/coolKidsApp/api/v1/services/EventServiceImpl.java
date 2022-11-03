package com.coolkids.coolKidsApp.api.v1.services;

import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl() {
        this.eventRepository = new EventRepository();
    }

    @Override
    public List<EventDTO> getAllEvents() { //TODO: The heck?
        return eventRepository.findAll() //TODO: The heck?
                .Stream() //TODO: The heck?
                .map(eventMapper::eventToEventDTO) //TODO: The heck?
                .collect(Collectors.toList()); //TODO: The heck?
    }
}
