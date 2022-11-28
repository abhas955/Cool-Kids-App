package com.coolkids.coolKidsApp.api.v1.mapper;

import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.domain.Event;

import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(source = "id",target = "id")
    EventDTO eventToEventDTO(Event event);
    Event eventDTOToEvent(EventDTO eventDTO);
}
