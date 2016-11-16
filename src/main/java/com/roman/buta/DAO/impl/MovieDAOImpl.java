package com.roman.buta.DAO.impl;
import com.roman.buta.DAO.MovieDAO;
import com.roman.buta.config.JPAUtil;
import com.roman.buta.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MovieDAOImpl implements MovieDAO{

    @Override
    public Movie saveOrUpdate(Movie movie) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Movie m = em.merge(movie);
        em.getTransaction().commit();
        em.close();
        return m;
    }

    @Override
    public List<String> findMoviesTitleByRatingIsNull() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT m.title FROM Movie m " +
                "WHERE m.id NOT IN(SELECT r.movie.id FROM Rating r)");
        List<String> moviesTitleList = query.getResultList();
        em.close();
        return moviesTitleList;
    }

    @Override
    public Movie findById(Integer movieId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        em.close();
        return movie;

    }

    @Override
    public List<Movie> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Movie> movieList = em.createQuery("FROM Movie m").getResultList();
        em.close();
        return movieList;
    }

    @Override
    public void deleteById(Integer movieId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Movie.class, movieId));
        em.getTransaction().commit();
        em.close();
    }
}
