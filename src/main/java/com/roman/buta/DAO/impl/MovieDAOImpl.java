package com.roman.buta.DAO.impl;
import com.roman.buta.DAO.MovieDAO;
import com.roman.buta.config.JPAUtil;
import com.roman.buta.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MovieDAOImpl extends GenericDAOImpl<Movie, Integer> implements MovieDAO{

    @Override
    public List<String> findMoviesTitleByRatingIsNull() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT m.title FROM Movie m " +
                "WHERE m.id NOT IN(SELECT r.movie.id FROM Rating r)");
        List<String> moviesTitleList = query.getResultList();
        em.close();
        return moviesTitleList;
    }

}
