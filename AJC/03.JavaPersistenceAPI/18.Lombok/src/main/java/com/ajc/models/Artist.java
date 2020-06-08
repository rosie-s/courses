package com.ajc.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="artist_table")
@NamedQuery(name="getFavInstrumentString", query="from Artist a where a.favouriteInstrument.instrumentType = :iType")
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return size == artist.size &&
                Objects.equals(bandName, artist.bandName) &&
                Objects.equals(manager, artist.manager) &&
                Objects.equals(sacemRegistration, artist.sacemRegistration) &&
                Objects.equals(favouriteInstrument, artist.favouriteInstrument) &&
                Objects.equals(playableInstruments, artist.playableInstruments) &&
                Objects.equals(media, artist.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandName, size, manager, sacemRegistration, favouriteInstrument, playableInstruments, media);
    }
}
