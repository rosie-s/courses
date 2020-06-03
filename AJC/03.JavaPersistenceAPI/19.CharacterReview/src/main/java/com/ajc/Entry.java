package com.ajc;

import com.ajc.dao.CharacterDAOImpl;
import com.ajc.dao.util.EntityManagerFactorySingleton;
import com.ajc.model.CharacterPlayer;
import com.ajc.model.Colour;
import com.ajc.model.Item;
import com.ajc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Entry {
    public static void main(String[] args) {

        CharacterDAOImpl characterDAO = new CharacterDAOImpl();
        CharacterPlayer bangalore = new CharacterPlayer("Bangalore", 70, 75, 60);
        CharacterPlayer wraith = new CharacterPlayer("Wraith", 90, 50, 70);
        CharacterPlayer bloodhound = new CharacterPlayer("Bloodhound", 80, 90, 90);
        CharacterPlayer ezio = new CharacterPlayer("Ezio", 100, 100, 100);
        characterDAO.create(bangalore);
        characterDAO.create(wraith);
        characterDAO.create(bloodhound);
        characterDAO.create(ezio);


        characterDAO.findById(1);
        characterDAO.findAll();
        characterDAO.findByName("Bangalore");
        characterDAO.findByName("Ezio");

        EntityManager entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // Add characters to user
        User userApex = new User("apex@game.com", "apex");
        userApex.getCharacters().add(bangalore);
        userApex.getCharacters().add(wraith);
        userApex.getCharacters().add(bloodhound);
        //bangalore.setUser(userApex);
       // wraith.setUser(userApex);
       // bloodhound.setUser(userApex);

        User userAssassin = new User("assassin@game.com", "assassin");
        userAssassin.getCharacters().add(ezio);
        ezio.setUser(userAssassin);

        // Add items
        Item hiddenBlade = new Item(4, Colour.BLACK);
        Item shield = new Item(5, Colour.BLUE);
        Item helmet = new Item(6, Colour.RED);
        Item sword = new Item(8, Colour.GREEN);



        try {
            transaction.begin();

            entityManager.persist(userAssassin);
            entityManager.persist(userApex);

            entityManager.persist(hiddenBlade);
            entityManager.persist(shield);
            entityManager.persist(helmet);
            entityManager.persist(sword);

            transaction.commit();
            entityManager.close();
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManager.close();

        }
    }
}
