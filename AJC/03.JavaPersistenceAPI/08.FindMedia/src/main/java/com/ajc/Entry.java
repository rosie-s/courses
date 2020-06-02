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

        try {
            transaction.begin();

            @Deprecated
            Date date = new Date(2005, 03, 8);

            Artist artist = new Artist("Gerard", "Way", "My Chemical Romance");
            MediaId mediaId = new MediaId("Three Cheers for Sweet Revenge",MediaType.CD);
            Media media = new Media(mediaId, date);

            System.out.println("*** Before Persist ***");
            System.out.println("Contains Artist: " + em.contains(artist));
            System.out.println("Contains Media: " + em.contains(media));

            System.out.println("*** Persist ***");
            em.persist(artist);
            em.persist(media);

            System.out.println("Contains Artist: " + em.contains(artist));
            System.out.println("Contains Media: " + em.contains(media));
            transaction.commit();

            em.close();
            em = emf.createEntityManager();
            System.out.println("Find Media: \n" + em.find(Media.class, mediaId));

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
