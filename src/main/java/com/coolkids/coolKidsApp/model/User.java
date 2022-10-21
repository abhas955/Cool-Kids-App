package com.coolkids.coolKidsApp;

import org.springframework.data.annotation.Id;

import java.net.URL;
import java.util.Date;

public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean emailVerified;
    private String emailVerifyToken;
    private String phoneNumber;
    private Boolean phoneNumberVerified;
    private URL profilePictureLink;
    private String password;
    private String passwordResetToken;
    private Date passwordResetTokenExpired;
    private enum AccountType {
        USER,
        ADMIN
    }
    private String mailingAddress;
    private enum Role {
        USER,
        ADMIN,
        PATIENT,
        MOTHER,
        FATHER,
        SIBLING
    }
    private String position;
    private enum Permission {
        READ,
        WRITE,
        DELETE
    }
    private Date accountCreatedDate;
    private Date accountUpdatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getEmailVerifyToken() {
        return emailVerifyToken;
    }

    public void setEmailVerifyToken(String emailVerifyToken) {
        this.emailVerifyToken = emailVerifyToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getPhoneNumberVerified() {
        return phoneNumberVerified;
    }

    public void setPhoneNumberVerified(Boolean phoneNumberVerified) {
        this.phoneNumberVerified = phoneNumberVerified;
    }

    public URL getProfilePictureLink() {
        return profilePictureLink;
    }

    public void setProfilePictureLink(URL profilePictureLink) {
        this.profilePictureLink = profilePictureLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public Date getPasswordResetTokenExpired() {
        return passwordResetTokenExpired;
    }

    public void setPasswordResetTokenExpired(Date passwordResetTokenExpired) {
        this.passwordResetTokenExpired = passwordResetTokenExpired;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public Date getAccountUpdatedDate() {
        return accountUpdatedDate;
    }

    public void setAccountUpdatedDate(Date accountUpdatedDate) {
        this.accountUpdatedDate = accountUpdatedDate;
    }

    //@Override
    //public String toString() {
        //return String.format(
                //"User[id=%s, firstName='%s', lastName='%s']",
                //id, firstName, lastName);
    //}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified=" + emailVerified +
                ", emailVerifyToken='" + emailVerifyToken + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneNumberVerified=" + phoneNumberVerified +
                ", profilePictureLink=" + profilePictureLink +
                ", password='" + password + '\'' +
                ", passwordResetToken='" + passwordResetToken + '\'' +
                ", passwordResetTokenExpired=" + passwordResetTokenExpired +
                ", mailingAddress='" + mailingAddress + '\'' +
                ", position='" + position + '\'' +
                ", accountCreatedDate=" + accountCreatedDate +
                ", accountUpdatedDate=" + accountUpdatedDate +
                '}';
    }
}
