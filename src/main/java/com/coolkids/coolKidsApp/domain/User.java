package com.coolkids.coolKidsApp.domain;

import com.coolkids.coolKidsApp.api.v1.mapper.EventMapper;
import com.coolkids.coolKidsApp.api.v1.model.EventDTO;
import com.coolkids.coolKidsApp.api.v1.model.EventListDTO;
import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    private String firstName;
    private String lastName;
    @NotBlank
    @Size(max = 50)
    private String email;
    private String birthdate;
    private String phoneNumber;
    @NotBlank
    @Size(max = 120)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    private String address;
    private Boolean locked = false;
    private Boolean enabled = true;
    private LocalDate accountCreatedDate;
    private LocalDate accountUpdatedDate;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_events",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "event_id") })
    private Set<Event> eventRsvps = new HashSet<>();
    private String profilePic;



    public User(String username, String firstName, String lastName, String email, String phoneNumber,
                String birthdate, String address, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.address = address;
        this.password = password;


    }

    public void addEvent(Event event){
        this.eventRsvps.add(event);
        event.getUserSetRsvps().add(this);
    }

    public void removeEvent(Long eventId){
        Event event = this.eventRsvps.stream().filter(e -> e.getId() == eventId).findFirst().orElse(null);
                if(event != null){
                    this.eventRsvps.remove(event);
                    event.getUserSetRsvps().remove(this);
                }
    }

    public Integer getEventsRsvpd(){
        return this.eventRsvps.size();
    }




//    public <T> List<T> convertSetToList(Set<T> set)
//    {
//        // create an empty list
//        List<T> list = new ArrayList<>();
//
//        // push each element in the set into the list
//        for (T t : set)
//            list.add(t);
//
//        // return the list
//        return list;
//    }



}
