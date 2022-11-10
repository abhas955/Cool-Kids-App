package com.coolkids.coolKidsApp.controllers;

import com.coolkids.coolKidsApp.services.eventServices.EventService;
import com.coolkids.coolKidsApp.services.eventServices.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //TODO: Is this what we need?
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final EventService eventService;

    public ImageController(ImageService imageService, EventService eventService) { //Error is due to blank image service
        this.imageService = imageService;
        this.eventService = eventService;
    }

    //@GetMapping("event/{id}/image") //GetMapping returns the form for the event id that's passed in.
    //public String showUploadForm(@PathVariable String id, Model model){
     //   model.addAttribute("event", eventService.getEventById(id));

        //return "event/imageuploadform"; //imageuploadform.html should be in templates
    //}

    //Handles the upload of the image
    //Takes in the id from the path then gets the request parameter image file passed from the form on the post.
    @PostMapping("event/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {
        imageService.saveImageFile(String.valueOf(id), file); //TODO: add saveImageFile (@6:00 on session 209)

        return "redirect:/event/" + id + "/show";
    }
}
