package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.controllers.EventController;
import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    private String getEventUrl(String id) {
        return EventController.BASE_URL + "/" + id;
    }

    @Override
    public EventDTO createNewEvent(EventDTO eventDTO) {
        return saveAndReturnDTO(eventMapper.eventDTOToEvent(eventDTO));
    }

    private EventDTO saveAndReturnDTO(Event event) {

        Event savedEvent = eventRepository.save(event);

        EventDTO returnDto = eventMapper.eventToEventDTO(savedEvent);

        returnDto.setEventUrl(EventController.BASE_URL + "/" + savedEvent.getId());

        return returnDto;
    }

    @Override
    public EventDTO saveEventByDTO(String id, EventDTO eventDTO){
        Event event = eventMapper.eventDTOToEvent(eventDTO);
        event.setId(id);

        return saveAndReturnDTO(event);
    }

    @Override
    public EventDTO patchEvent(String id, EventDTO eventDTO){
        return eventRepository.findById(id).map(event -> {

            if(eventDTO.getTime() != null){
                event.setTime(eventDTO.getTime());
            }

            if(eventDTO.getTitle() != null) {
                event.setTitle(eventDTO.getTitle());
            }

            if(eventDTO.getLocation() != null) {
                event.setLocation(eventDTO.getLocation());
            }

            if(eventDTO.getDesc() != null) {
                event.setDesc(eventDTO.getDesc());
            }

            if(eventDTO.getImg() != null) {
                event.setImg(eventDTO.getImg());
            }

            EventDTO returnDTO = eventMapper.eventToEventDTO(eventRepository.insert(event));

            returnDTO.setEventUrl(getEventUrl(id));

            return returnDTO;

        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(event -> {
                    EventDTO eventDTO = eventMapper.eventToEventDTO(event);
                    eventDTO.setEventUrl(getEventUrl(event.getId()));
                    return eventDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(String id) {
        return eventRepository.findById(id)
                .map(eventMapper::eventToEventDTO)
                .map(eventDTO -> {
                    //set API URL
                    eventDTO.setEventUrl(getEventUrl(id));
                    return eventDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public EventDTO getEventByTitle(String title) {
        return eventMapper.eventToEventDTO(eventRepository.findByTitle(title));
    }

    @Override
    public EventDTO getEventByTime(String time) {
        return eventMapper.eventToEventDTO(eventRepository.findByTime(time));
    }

    //By I've RSVP'd

    //By I've created

    @Override
    public void deleteEventById(String id) {
        eventRepository.deleteById(id);
    }
}
