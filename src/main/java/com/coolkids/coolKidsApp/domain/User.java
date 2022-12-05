package com.coolkids.coolKidsApp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;


@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String birthdate;
    @DBRef
    private Set<Role> roles = new HashSet<>();

    @DBRef
    private Set<Event> events;
    //    private Boolean emailVerified;
//    private String emailVerifyToken;
    private String phoneNumber;
//    private Boolean phoneNumberVerified;
//    private URL profilePictureLink;
    private String password;
//    private String passwordResetToken;
//    private Date passwordResetTokenExpired;
    @Indexed
    @Field(targetType = FieldType.STRING)
    private UserRole userRole;

    private String address;
    private Boolean locked = false;
    private Boolean enabled = true;
//    private enum Role {
//        USER,
//        ADMIN,
//        PATIENT,
//        MOTHER,
//        FATHER,
//        SIBLING
//    }
//    private String position;
//    private enum Permission {
//        READ,
//        WRITE,
//        DELETE
//    }
    private Date accountCreatedDate;
    private Date accountUpdatedDate;

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




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//
//
//    public String getPasswordResetToken() {
//        return passwordResetToken;
//    }
//
//    public void setPasswordResetToken(String passwordResetToken) {
//        this.passwordResetToken = passwordResetToken;
//    }
//
//    public Date getPasswordResetTokenExpired() {
//        return passwordResetTokenExpired;
//    }
//
//    public void setPasswordResetTokenExpired(Date passwordResetTokenExpired) {
//        this.passwordResetTokenExpired = passwordResetTokenExpired;
//    }


//    public String getPosition() {
//        return position;
//    }

//    public void setPosition(String position) {
//        this.position = position;
//    }



//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", emailVerified=" + emailVerified +
//                ", emailVerifyToken='" + emailVerifyToken + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", phoneNumberVerified=" + phoneNumberVerified +
//                ", profilePictureLink=" + profilePictureLink +
//                ", password='" + password + '\'' +
//                ", passwordResetToken='" + passwordResetToken + '\'' +
//                ", passwordResetTokenExpired=" + passwordResetTokenExpired +
//                ", mailingAddress='" + mailingAddress + '\'' +
////                ", position='" + position + '\'' +
//                ", accountCreatedDate=" + accountCreatedDate +
//                ", accountUpdatedDate=" + accountUpdatedDate +
//                '}';
//    }
}
