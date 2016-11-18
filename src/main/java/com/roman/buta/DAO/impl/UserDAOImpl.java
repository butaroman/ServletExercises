package com.roman.buta.DAO.impl;

import com.roman.buta.DAO.UserDAO;
import com.roman.buta.config.JPAUtil;
import com.roman.buta.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl  extends GenericDAOImpl<User, Integer> implements UserDAO{


    @Override
    public List<Integer> findUsersIdByRatingDateIsNull() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Integer> userIdList = em.createQuery("SELECT u.id FROM User u WHERE u.id IN" +
                "(SELECT r.user FROM Rating r WHERE ratingDate IS NULL )").getResultList();
        em.close();
        return userIdList;
    }

}
