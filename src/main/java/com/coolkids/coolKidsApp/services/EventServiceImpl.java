package com.coolkids.coolKidsApp.services;

import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.domain.Event;
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

    //This is in the Udemy course example (Video #193 @ 11:04) but not UserServiceImpl
    //probably because of eventmapper.
    //public EventServiceImpl(EventRepository eventRepository) {this.eventRepository = eventRespository; }

    private final EventMapper eventMapper;

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::eventToEventDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(String id) {
        return eventMapper.eventToEventDTO(eventRepository.findEventById(id));
    }

    @Override
    public String createEvent(Event event) {
        boolean eventExists = eventRepository.
                findById(event.getId()).
                isPresent();
        if(eventExists){
            throw new IllegalStateException("Event Already Exists");
        }

        eventRepository.save(event);
        return "Event Successfully Created";
    }
}
