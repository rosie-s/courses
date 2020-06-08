package com.ajc.dao;

import com.ajc.models.Artist;
import com.ajc.models.QArtist;
import com.ajc.util.EntityManagerFactorySingleton;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ArtistDAOImpl implements ArtistDAO {

    Artist artist = null;
    List<Artist> artists = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    @Override
    public List<Artist> findByLastName(String lastName) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            QArtist qArtist = QArtist.artist;
            JPQLQuery<Artist> query = new JPAQuery<>(entityManager);
            query.from(qArtist).where(qArtist.lastName.eq(lastName));
            artists = query.fetch();
            System.out.println("Lastname: " + artists.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return artists;
    }

    @Override
    public List<Artist> findAll() {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            QArtist qArtist = QArtist.artist;
            JPQLQuery<Artist> query = new JPAQuery<>(entityManager);
            query.from(qArtist);
            artists = query.fetch();
            System.out.println("All: " + artists.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return artists;
    }

    @Override
    public Artist findById(Long key) {
        try {
            entityManager = EntityManagerFactorySingleton.getInstance().getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            artist = entityManager.find(Artist.class, key);
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
        return artist;
    }

    @Override
    public void create(Artist entity) {
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
    public void update(Artist entity) {
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
    public void delete(Artist entity) {
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
    public void deleteByKey(Long key) {
        artist = findById(key);
        if (artist != null) {
            delete(artist);
        }
    }
}
