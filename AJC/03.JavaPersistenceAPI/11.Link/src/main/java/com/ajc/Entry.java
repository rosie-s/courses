package com.ajc;

import com.ajc.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Entry {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("music");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        @Deprecated
        Date date = new Date(2005, 03, 8);

        Artist artist = new Artist("Gerard", "Way", "My Chemical Romance");

        Media media = new Media(new MediaId("Three Cheers for Sweet Revenge", MediaType.CD), date);
        Media media2 = new Media(new MediaId("Welcome to the Black Parade", MediaType.CD), date);
        media2.setName("WTTBP");
        Media media3 = em.merge(media2);

        Manager manager = new Manager("FirstName", "LastName");
        Artist artist2 = new Artist("Mike", "Shinoda", "Linkin Park");
        artist2.setManager(manager);


        try {
            transaction.begin();

            System.out.println("*** Before Persist ***");
            System.out.println("Contains Artist 1: " + em.contains(artist) + " Artist 2: " + em.contains(artist2));
            System.out.println("Contains Media: " + em.contains(media));
            System.out.println("Contains Manager: " + em.contains(manager));

            System.out.println("*** Persist ***");
            em.persist(artist);
            em.persist(media);
            em.persist(manager);
            em.persist(artist2);

            System.out.println("Contains Artist 1: " + em.contains(artist) + " Artist 2: " + em.contains(artist2));
            System.out.println("Contains Media: " + em.contains(media));
            System.out.println("Contains Manager: " + em.contains(manager));

            System.out.println("Get Media 3 name: " + media3.getName());
            transaction.commit();
            em.close();

            em = emf.createEntityManager();
            System.out.println("Find Media: \n" + em.find(Media.class, media.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
