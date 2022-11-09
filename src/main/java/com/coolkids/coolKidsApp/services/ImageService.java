package com.coolkids.coolKidsApp.services;

import org.springframework.web.multipart.MultipartFile; //TODO: what is this for?

public interface ImageService {

    void saveImageFile(String eventId, MultipartFile file);
}
