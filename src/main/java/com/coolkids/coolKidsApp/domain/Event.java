package com.coolkids.coolKidsApp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)

    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private LocalDate eventCreatedDate;
    private LocalDate eventUpdatedDate;
    private String eventTitle;
    private String eventType;
    //private String eventPhoto;
    private Integer maxAttendance;
    private Integer currentRSVPS;
    private String eventAddress;
    private String eventDescription;
    private String contactPersonName;
    //private String contactPersonPicture;
    private Integer contactPersonPhoneNumber;
    private String contactPersonEmail;


}

