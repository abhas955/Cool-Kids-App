package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventMapper eventMapper, EventRepository eventRepository) {
        this.eventMapper = eventMapper;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO){
        Event event = eventMapper.eventDTOToEvent(eventDTO);

        Event savedEvent = eventRepository.insert(event);

        EventDTO returnDto = eventMapper.eventToEventDTO(savedEvent);

        returnDto.setEventUrl("/api/v1/events/" + savedEvent.getId());

        return returnDto;
    }

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
    public Void deleteEventById(String idToDelete) {
        eventRepository.deleteById(idToDelete);
        return null;
    }
}
