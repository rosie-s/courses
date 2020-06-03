package com.ajc.dao;

import com.ajc.model.CharacterPlayer;
import com.ajc.dao.util.EntityManagerFactorySingleton;

import javax.persistence.*;
import java.util.List;

public class CharacterDAOImpl implements CharacterDAO {

    CharacterPlayer character = null;
    List<CharacterPlayer> characters = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public List<CharacterPlayer> findByName(String name) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            Query query = entityManager.createQuery("from CharacterPlayer a where a.name = :name");
            query.setParameter("name", name);
            characters = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return characters;
    }

    @Override
    public List<CharacterPlayer> findAll() {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            Query query = entityManager.createQuery("from CharacterPlayer a");
            characters = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return characters;
    }

    @Override
    public CharacterPlayer findById(Integer key) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            character = entityManager.find(CharacterPlayer.class, key);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return character;
    }

    @Override
    public void create(CharacterPlayer entity) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(CharacterPlayer entity) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(CharacterPlayer entity) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteByKey(Integer key) {
        character = findById(key);
        if (character != null) {
            delete(character);
        }
    }
}
