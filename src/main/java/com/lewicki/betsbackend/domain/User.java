package com.lewicki.betsbackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createTime;
    private double balance;
    private boolean loggedIn;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createTime = LocalDateTime.now();
        this.loggedIn = false;
        this.balance = 1000;
    }
}
