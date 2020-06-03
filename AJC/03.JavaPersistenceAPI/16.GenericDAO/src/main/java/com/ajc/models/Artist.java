package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artist_table")
@NamedQuery(name="getFavInstrumentString", query="from Artist a where a.favouriteInstrument.instrumentType = :iType")
@NamedQuery(name="getByLastName", query= "from Artist a where a.lastName = :lastName")
@NamedQuery(name="getAll", query= "from Artist a")
public class Artist extends Person{

    @Column(name ="bandName")
    private String bandName;

    @Column(name ="band_size")
    private int size;

    @ManyToOne
    private Manager manager;

    @OneToOne(cascade = CascadeType.REMOVE)
    private SacemRegistration sacemRegistration;

    @ManyToOne
    private Instrument favouriteInstrument;

    @ManyToMany(fetch = FetchType.EAGER)
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

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public SacemRegistration getSacemRegistration() {
        return sacemRegistration;
    }

    public void setSacemRegistration(SacemRegistration sacemRegistration) {
        this.sacemRegistration = sacemRegistration;
    }

    public Instrument getFavouriteInstrument() {
        return favouriteInstrument;
    }

    public void setFavouriteInstrument(Instrument favouriteInstrument) {
        this.favouriteInstrument = favouriteInstrument;
    }

    public List<Instrument> getPlayableInstruments() {
        return playableInstruments;
    }

    public void setPlayableInstruments(List<Instrument> playableInstruments) {
        this.playableInstruments = playableInstruments;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
