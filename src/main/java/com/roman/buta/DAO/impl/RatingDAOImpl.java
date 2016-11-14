package com.roman.buta.DAO.impl;

import com.roman.buta.DAO.RatingDAO;
import com.roman.buta.config.JPAUtil;
import com.roman.buta.model.Rating;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RatingDAOImpl implements RatingDAO{

    @Override
    public Rating saveOrUpdate(Rating rating) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Rating updatedRating = em.merge(rating);
        em.getTransaction().commit();
        em.close();
        return updatedRating;
    }

    @Override
    public List<Rating> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Rating> ratingList = em.createQuery("FROM Rating r").getResultList();
        em.close();
        return ratingList;
    }

    @Override
    public List<Rating> findRatingsWithRatingDateIsNullByUserId(Integer userId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM Rating r WHERE r.ratingDate IS NULL AND r.user.id = :userId");
        query.setParameter("userId", userId);
        List<Rating> ratingList =  query.getResultList();
        em.close();
        return ratingList;
    }

    @Override
    public List<Object[]> findByRatingOrderByRatingDateAsc(Integer minRating, Integer maxRating) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT m.id, r.ratingDate FROM Movie m " +
                "INNER JOIN m.rating r WHERE r.rating BETWEEN :minRating AND :maxRating ORDER BY r.ratingDate");
        query.setParameter("minRating", minRating);
        query.setParameter("maxRating", maxRating);
        List<Object[]> resultList =  query.getResultList();
        em.close();
        return resultList;
    }

    @Override
    public List<Object[]> findRatingInfo() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT m.title, u.name, r.rating FROM Rating r " +
                "INNER JOIN r.movie m INNER JOIN r.user u");
        List<Object[]> resultList = query.getResultList();
        em.close();
        return resultList;
    }
}
