package com.ajc.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = "email_address")
    private String email;

    @Column(name = "login_name")
    private String login;

    public User(String email, String login) {
        this.email = email;
        this.login = login;
    }

    @OneToMany(mappedBy = "user")
    private List<CharacterPlayer> characters = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", characters=" + characters +
                '}';
    }
}
