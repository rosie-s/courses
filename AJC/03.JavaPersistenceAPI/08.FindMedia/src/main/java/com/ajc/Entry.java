package com.ajc;

import com.ajc.models.Artist;
import com.ajc.models.Manager;
import com.ajc.models.Media;
import com.ajc.models.MediaId;

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

            @Deprecated
            Date date = new Date(2005, 03, 8);

            Artist artist = new Artist("Gerard", "Way", "My Chemical Romance");
            Media media = new Media("Three Cheers for Sweet Revenge", date);

            System.out.println(em.contains(artist));
            System.out.printf("Persist");
            em.persist(artist);
            em.persist(media);

            System.out.println(em.contains(artist));
            transaction.commit();

            em.close();
            em = emf.createEntityManager();

            System.out.println(em.find(Media.class, 1));


        } catch (Exception e) {
            //transaction.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
