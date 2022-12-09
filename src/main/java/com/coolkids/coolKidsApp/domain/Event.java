package com.coolkids.coolKidsApp.domain;



import lombok.*;
//import jdk.javadoc.internal.doclets.formats.html.markup.Text;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.DBRef;


import javax.persistence.*;
import java.util.HashSet;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "eventStartDateTime")
    private String eventStartDateTime;
    @Column(name = "eventEndDateTime")
    private String eventEndDateTime;
    @Column(name = "eventCreatedDate")
    private String eventCreatedDate;
    @Column(name = "eventUpdatedDate")
    private String eventUpdatedDate;
    @Column(name = "eventTitle")
    private String eventTitle;
    @Column(name = "eventType")
    private String eventType;
    @Column(name = "eventPhotoUrl")
    private String eventPhotoUrl;
    @Column(name = "maxAttendance")
    private Integer maxAttendance;
    @Column(name = "currentRSVPS")
    private Integer currentRSVPS;
    @Column(name = "eventAddress")
    private String eventAddress;
    @Column(columnDefinition = "TEXT", name = "eventDescription")
    private String eventDescription;
    @Column(name = "contactPersonName")
    private String contactPersonName;
    @Column(name = "contactPersonNumber")
    private String contactPersonPhoneNumber;
    @Column(name = "contactPersonEmail")
    private String contactPersonEmail;
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
    mappedBy = "eventRsvps")
    @JsonIgnore
    private Set<User> userSetRsvps = new HashSet<>();



    public Integer getRsvps(){
        return this.userSetRsvps.size();
    }

}

