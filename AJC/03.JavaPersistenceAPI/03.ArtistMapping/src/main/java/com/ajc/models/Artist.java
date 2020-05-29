package com.ajc.models;

import javax.persistence.*;

@Entity
@Table(name="artist_table")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="fName")
    private String firstName;

    @Column(name ="lName")
    private String lastName;

    @Column(name ="bName")
    private String bandName;

    private int size;

    @ManyToOne
    private Manager manager;

    public Artist(String firstName, String lastName, String bandName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bandName = bandName;
    }
}
