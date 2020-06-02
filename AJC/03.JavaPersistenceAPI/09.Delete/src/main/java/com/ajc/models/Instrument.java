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

}
