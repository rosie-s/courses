package com.ajc;

import com.ajc.dao.ArtistDAOImpl;
import com.ajc.models.*;

import java.util.List;


public class Entry {
    public static void main(String[] args) {
        ArtistDAOImpl artistDAO = new ArtistDAOImpl();
        Artist artist = new Artist("Mike", "Shinoda", "Linkin Park");
        artistDAO.create(artist);
        artistDAO.findById(1L);
        artistDAO.findAll();
        artistDAO.findByLastName("Shinoda");
    }
}
