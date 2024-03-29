package com.ajc;

import com.ajc.models.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

public class Entry {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("music");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        @Deprecated
        Date date = new Date(2005, 03, 8);

        // Multiple Links
        Artist benjamin = new Artist("Benjamin", "Burnley", "Breaking Benjamin");
        Manager bManager = new Manager("Jeromy", "Jerome");
        SacemRegistration sacemRegistration = new SacemRegistration("BB1234");
        Media phobia = new Media(new MediaId("Phobia", MediaType.CD), date);
        Media ember = new Media(new MediaId("Ember", MediaType.CD), date);

        // 1 manager;
        benjamin.setManager(bManager);
        bManager.getArtists().add(benjamin);

        // 1 Sacem Reg
        sacemRegistration.setArtist(benjamin);
        benjamin.setSacemRegistration(sacemRegistration);

        // 2 Media
        phobia.setArtist(benjamin);
        ember.setArtist(benjamin);
        benjamin.getMedia().add(phobia);
        benjamin.getMedia().add(ember);

        // Instruments
        Instrument guitar = new Instrument("Guitar", InstrumentType.STRING);
        guitar.getArtistFavouriteInstrument().add(benjamin);
        Instrument drums = new Instrument("Drums", InstrumentType.PERCUSSION);
        drums.getArtistPlayableInstruments().add(benjamin);
        benjamin.getPlayableInstruments().add(guitar);
        benjamin.getPlayableInstruments().add(drums);
        benjamin.setFavouriteInstrument(guitar);

        //Try Cascade and Eager
        Artist aaron = new Artist("Aaron", "Bruch", "Breaking Benjamin");
        SacemRegistration sacemReg = new SacemRegistration("AB1234");
        aaron.setSacemRegistration(sacemReg);
        aaron.setFavouriteInstrument(drums);
        aaron.getPlayableInstruments().add(guitar);

        try {
            transaction.begin();

            System.out.println("*** Persist ***");
            em.persist(benjamin);
            em.persist(bManager);
            em.persist(phobia);
            em.persist(ember);
            em.persist(sacemRegistration);
            em.persist(guitar);
            em.persist(drums);
            em.persist(aaron);
            em.persist(sacemReg);

            //Query

            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Artist> query = cb.createQuery(Artist.class);
            Root<Artist> artistRoot = query.from(Artist.class) ;
            Join<Artist, Instrument> artistInstrumentJoin = artistRoot.join("favouriteInstrument");

            ParameterExpression<InstrumentType> parameterExpression = cb.parameter(InstrumentType.class);
            // query.select(artistRoot).where(cb.equal(artistRoot.get("firstName"), parameterExpression));
            query.select(artistRoot).where(cb.equal(artistInstrumentJoin.get("instrumentType"), parameterExpression));

            Query q = em.createQuery(query);
            q.setParameter(parameterExpression, InstrumentType.STRING);
            List<Artist> artists = q.getResultList();

            System.out.println("Artist Size: " + artists.size());

            transaction.commit();
            em.close();
            em = emf.createEntityManager();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
