package com.ajc;

import com.ajc.dao.CharacterDAOImpl;
import com.ajc.dao.util.EntityManagerFactorySingleton;
import com.ajc.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


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
        User userAssassin = new User("assassin@game.com", "assassin");
        User userOrc = new User("orc@game.com", "orc");
        User userWizard = new User("wizard@game.com", "wizard");

        bangalore.setUser(userApex);
        wraith.setUser(userApex);
        bloodhound.setUser(userApex);
        ezio.setUser(userAssassin);

        userApex.getCharacters().add(bangalore);
        userApex.getCharacters().add(wraith);
        userApex.getCharacters().add(bloodhound);
        userAssassin.getCharacters().add(ezio);

        // Add items
        Item hiddenBlade = new Item("Hidden Blade", 5, 4, Colour.BLACK);
        Item shield = new Item("Shield", 10, 10, Colour.BLUE);
        Item helmet = new Item("Helmet", 2, 20, Colour.RED);
        Item sword = new Item("Sword", 15, 25, Colour.GREEN);

        hiddenBlade.getCharacterItems().add(ezio);
        shield.getCharacterItems().add(bangalore);
        helmet.getCharacterItems().add(wraith);
        sword.getCharacterItems().add(bloodhound);

        ezio.getItems().add(hiddenBlade);
        bangalore.getItems().add(shield);
        wraith.getItems().add(helmet);
        bloodhound.getItems().add(sword);

        // Add Spells
        Spell rollingThunder = new Spell("Rolling Thunder", 70, 500, 70);
        Spell dimensionalRift = new Spell("Dimensional Rift", 80, 900, 20);
        Spell both = new Spell("Beast of the hunt", 90, 1000, 99);

        bangalore.getSpells().add(rollingThunder);
        wraith.getSpells().add(dimensionalRift);
        bloodhound.getSpells().add(both);
        ezio.getSpells().add(dimensionalRift);

        rollingThunder.getCharacterSpells().add(bangalore);
        dimensionalRift.getCharacterSpells().add(wraith);
        dimensionalRift.getCharacterSpells().add(ezio);
        both.getCharacterSpells().add(bloodhound);

        // Orc
        Orc orc = new Orc("An orc", 50, 2, 1);
        orc.setRage(500);
        orc.setUser(userOrc);
        userOrc.getCharacters().add(orc);
        sword.getCharacterItems().add(orc);
        orc.getItems().add(sword);
        orc.getSpells().add(rollingThunder);
        rollingThunder.getCharacterSpells().add(orc);

        // Wizard
        Wizard wizard = new Wizard("A Wizard", 80, 50, 9000);
        wizard.setMagic(509);
        wizard.setUser(userWizard);
        userWizard.getCharacters().add(wizard);
        hiddenBlade.getCharacterItems().add(wizard);
        wizard.getItems().add(hiddenBlade);
        wizard.getSpells().add(dimensionalRift);
        dimensionalRift.getCharacterSpells().add(wizard);

        // Character No Dao
        CharacterPlayer character = new CharacterPlayer("Test User Link", 30, 30, 2);
        character.setUser(userApex);
        userApex.getCharacters().add(character);

        // Delete
        CharacterPlayer characterDelete = new CharacterPlayer("Test Delete", 30, 30, 2);
        CharacterPlayer characterDelete2 = new CharacterPlayer("Test Delete 2", 30, 30, 2);
        //characterDAO.create(characterDelete);
        //characterDAO.create(characterDelete2);
        characterDAO.deleteByKey(5);
        characterDAO.delete(characterDelete2);

        try {
            transaction.begin();

            entityManager.persist(userAssassin);
            entityManager.persist(userApex);
            entityManager.persist(userOrc);
            entityManager.persist(userWizard);

            entityManager.persist(hiddenBlade);
            entityManager.persist(shield);
            entityManager.persist(helmet);
            entityManager.persist(sword);

            entityManager.persist(rollingThunder);
            entityManager.persist(dimensionalRift);
            entityManager.persist(both);

            entityManager.persist(orc);
            entityManager.persist(wizard);

            entityManager.persist(character);

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
