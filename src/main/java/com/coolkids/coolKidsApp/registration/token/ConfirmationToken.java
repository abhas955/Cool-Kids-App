//package com.coolkids.coolKidsApp.registration.token;
//
//import com.coolkids.coolKidsApp.domain.User;
//import com.mongodb.lang.NonNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class ConfirmationToken {
//    private Long id;
//    @NonNull
//    private String token;
//    @NonNull
//    private LocalDateTime createdAt;
//    @NonNull
//    private LocalDateTime expiredAt;
//    private LocalDateTime confirmedAt;
//
//    @DBRef()
//    private User user;
//
//    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, LocalDateTime confirmedAt,User user) {
//        this.token = token;
//        this.createdAt = createdAt;
//        this.expiredAt = expiredAt;
//        this.confirmedAt = confirmedAt;
//        this.user = user;
//    }
//}
