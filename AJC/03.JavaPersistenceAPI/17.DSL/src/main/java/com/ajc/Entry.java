package com.ajc;

import com.ajc.dao.ArtistDAOImpl;
import com.ajc.models.*;

import java.util.List;


public class Entry {
    public static void main(String[] args) {
        ArtistDAOImpl artistDAO = new ArtistDAOImpl();
        Artist artist = new Artist("Mike", "Shinoda", "Linkin Park");
        Artist artist2 = new Artist("Jared", "Leto", "3STM");
        artistDAO.create(artist);
        artistDAO.create(artist2);
        artistDAO.findById(1L);
        artistDAO.findAll();
        artistDAO.findByLastName("Shinoda");
    }
}
