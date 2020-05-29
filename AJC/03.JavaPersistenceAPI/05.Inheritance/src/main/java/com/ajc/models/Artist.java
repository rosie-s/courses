package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artist_table")
public class Artist extends Person{

    @Column(name ="bName")
    private String bandName;

    private int size;

    @ManyToOne
    private Manager manager;

    @OneToOne
    private SacemRegistration sacemRegistration;

    @ManyToOne
    private Instrument favouriteInstrument;

    @ManyToMany
    @JoinTable( name="art_inst",
            joinColumns = @JoinColumn(name="art_id"),
            inverseJoinColumns = @JoinColumn(name="ins_id"))
    private List<Instrument> playableInstruments = new ArrayList<>();

    public Artist(String firstName, String lastName, String bandName) {
        super(firstName,lastName);
        this.bandName = bandName;
    }
}
