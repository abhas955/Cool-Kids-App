package com.coolkids.coolKidsApp.domain;

import lombok.*;

import org.springframework.data.mongodb.core.mapping.DBRef;


import javax.persistence.*;
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
    private String eventStartDateTime;
    private String eventEndDateTime;
    private String eventCreatedDate;
    private String eventUpdatedDate;
    private String eventTitle;
    private String eventType;
    //private String eventPhotoUrl;
    private Integer maxAttendance;
    private Integer currentRSVPS;
    private String eventAddress;
    private String eventDescription;
    private String contactPersonName;
    private Integer contactPersonPhoneNumber;
    private String contactPersonEmail;
    @ManyToMany
    private Set<User> userSet;

}

