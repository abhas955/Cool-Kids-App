package com.coolkids.coolKidsApp.services.eventServices;

import com.coolkids.coolKidsApp.domain.Event;
import com.coolkids.coolKidsApp.repository.EventRepository;
import com.coolkids.coolKidsApp.services.eventServices.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j //Todo: What is this for?
@Service
public class ImageServiceImpl implements ImageService {

    private final EventRepository eventRepository;
    public ImageServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Transactional
    public void saveImageFile(Long eventId, MultipartFile file) { //Takes in eventId and multipart file from controller

        try {
            Event event = eventRepository.findById(eventId).get(); //Get event object out of repository since we are saving against an existing event.

            //Multipart file uses Java primitive byte array. Lines 28-34 converts the file to a Wrapper Byte Object.
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }


            //event.setImage(byteObjects);

            eventRepository.save(event);
        } catch (IOException e) {
            //todo handle this exception better
            log.error("Error occured", e);

            e.printStackTrace();
        }
    }

    @Override
    public void saveImageFile(String eventId, MultipartFile file) {

    }
}
