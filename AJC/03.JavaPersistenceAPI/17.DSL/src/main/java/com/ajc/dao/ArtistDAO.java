package com.ajc.dao;

import com.ajc.models.Artist;
import com.ajc.models.InstrumentType;

import java.util.List;

public abstract interface ArtistDAO extends GenericDAO<Artist, Long>{
    public List<Artist> findByLastName(String lastName);
}
