package com.ajc;

import com.ajc.models.Artist;
import com.ajc.models.Media;

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

        try {
            transaction.begin();

            Artist artist = new Artist("Gerard", "Way", "My Chemical Romance");
            System.out.println(em.contains(artist));
            System.out.printf("Persist");
            em.persist(artist);
            // Remove
            System.out.println(em.contains(artist));
            em.remove(artist);
            System.out.println(em.contains(artist));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
