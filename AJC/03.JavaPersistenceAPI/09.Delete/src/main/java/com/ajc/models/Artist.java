package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artist_table")
public class Artist extends Person{

    @Column(name ="bandName")
    private String bandName;

    @Column(name ="band_size")
    private int size;

    @ManyToOne
    private Manager manager;

    @OneToOne
    private SacemRegistration sacemRegistration;

    @ManyToOne
    private Instrument favouriteInstrument;

    @ManyToMany
    @JoinTable( name="artist_instruments",
            joinColumns = @JoinColumn(name="art_id"),
            inverseJoinColumns = @JoinColumn(name="ins_id"))
    private List<Instrument> playableInstruments = new ArrayList<>();

    @OneToMany(mappedBy = "artist")
    private List<Media> media = new ArrayList<>();

    public Artist(String firstName, String lastName, String bandName) {
        super(firstName,lastName);
        this.bandName = bandName;
    }
    public Artist() {
    }

}
