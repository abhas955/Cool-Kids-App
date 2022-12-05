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
    public EventDTO saveEventByDTO(Long id, EventDTO eventDTO){
        Event event = eventMapper.eventDTOToEvent(eventDTO);
        event.setId(id);

        return saveAndReturnDTO(event);
    }


    public EventDTO patchEvent(Long id, EventDTO eventDTO){
        return eventRepository.findById(id).map(event -> {

            if(eventDTO.getEventStartDateTime() != null){
                event.setEventStartDateTime(eventDTO.getEventStartDateTime());
            }

            if(eventDTO.getEventEndDateTime() != null) {
                event.setEventEndDateTime(eventDTO.getEventEndDateTime());
            }

            if(eventDTO.getEventCreatedDate() != null) {
                event.setEventCreatedDate(eventDTO.getEventCreatedDate());
            }

            if(eventDTO.getEventUpdatedDate() != null) {
                event.setEventUpdatedDate(eventDTO.getEventUpdatedDate());
            }

            if(eventDTO.getEventTitle() != null) {
                event.setEventTitle(eventDTO.getEventTitle());
            }

            if(eventDTO.getEventType() != null) {
                event.setEventType(eventDTO.getEventType());
            }
            /*
            if(eventDTO.getEventPhoto() != null) {
                event.setEventPhoto(eventDTO.getEventPhoto());
            }
            */

            if(eventDTO.getMaxAttendance() != null) {
                event.setMaxAttendance(eventDTO.getMaxAttendance());
            }

            if(eventDTO.getCurrentRSVPS() != null) {
                event.setMaxAttendance(eventDTO.getMaxAttendance());
            }

            if(eventDTO.getCurrentRSVPS() != null) {
                event.setCurrentRSVPS(eventDTO.getCurrentRSVPS());
            }

            if(eventDTO.getEventAddress() != null) {
                event.setEventAddress(eventDTO.getEventAddress());
            }

            if(eventDTO.getEventDescription() != null) {
                event.setEventDescription(eventDTO.getEventDescription());
            }

            if(eventDTO.getContactPersonName() != null) {
                event.setContactPersonName(eventDTO.getContactPersonName());
            }
            /*
            if(eventDTO.getContactPersonPhoto() != null) {
                event.setContactPersonPhoto(eventDTO.getContactPersonPhoto());
            }
             */
            if(eventDTO.getContactPersonEmail() != null) {
                event.setContactPersonEmail(eventDTO.getContactPersonEmail());
            }

            EventDTO returnDTO = eventMapper.eventToEventDTO(eventRepository.save(event));

            returnDTO.setEventUrl(eventDTO.getEventUrl());

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
    public EventDTO getEventById(Long id) {
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
        return eventMapper.eventToEventDTO(eventRepository.findByEventTitle(title));
    }

    @Override
    public EventDTO getEventByStartDateTime(String eventStartDateTime) {
        return eventMapper.eventToEventDTO(eventRepository.findByEventStartDateTime(eventStartDateTime));
    }

    //By I've RSVP'd

    @Override
    public EventDTO getEventByType(String type) {
        return eventMapper.eventToEventDTO(eventRepository.findByEventType(type));
    }

    private String getEventUrl(Long id) {
        return EventController.BASE_URL + "/" + id;
    }

    //By I've created

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}
