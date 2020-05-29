package com.ajc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {
    @Id
    private  Long id;

    @Column(name ="FIRST_NAME")
    private String firstName;

    @Column(name ="LAST_NAME")
    private String lastName;

    @Column(name ="BAND_NAME")
    private String bandName;

    @Column(name ="SIZE")
    private int size;

    public Artist(String firstName, String lastName, String bandName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bandName = bandName;
    }
}
