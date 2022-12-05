package com.coolkids.coolKidsApp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "events",uniqueConstraints = {
        @UniqueConstraint(columnNames = "eventTitle"),
})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private String title;
    private String location;
    private String desc;
    private String img;
    private String eventStartDateTime;
    private String eventEndDateTime;
    private String eventCreatedDate;
    private String eventUpdatedDate;
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
    @ManyToMany
    private Set<User> userSet;


}

