package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instrument_table")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "instrument")
    public String name;

    @Enumerated(EnumType.STRING)
    @Column(name ="instrument_type")
    private InstrumentType instrumentType;

    @ManyToMany(mappedBy = "playableInstruments")
    private List<Artist> artistPlayableInstruments = new ArrayList<>();

    @OneToMany(mappedBy = "favouriteInstrument")
    private List<Artist> artistFavouriteInstrument = new ArrayList<>();

    public Instrument(String name, InstrumentType instrumentType) {
        this.name = name;
        this.instrumentType = instrumentType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public List<Artist> getArtistPlayableInstruments() {
        return artistPlayableInstruments;
    }

    public void setArtistPlayableInstruments(List<Artist> artistPlayableInstruments) {
        this.artistPlayableInstruments = artistPlayableInstruments;
    }

    public List<Artist> getArtistFavouriteInstrument() {
        return artistFavouriteInstrument;
    }

    public void setArtistFavouriteInstrument(List<Artist> artistFavouriteInstrument) {
        this.artistFavouriteInstrument = artistFavouriteInstrument;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instrumentType=" + instrumentType +
                ", artistPlayableInstruments=" + artistPlayableInstruments +
                ", artistFavouriteInstrument=" + artistFavouriteInstrument +
                '}';
    }
}
