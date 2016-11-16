package com.roman.buta.DAO.impl;

import com.roman.buta.DAO.UserDAO;
import com.roman.buta.config.JPAUtil;
import com.roman.buta.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Override
    public User findById(Integer userId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM User u WHERE u.id = :userId");
        query.setParameter("userId", userId);
        Object res = query.getSingleResult();
        em.close();
        if(res == null) {
            return null;
        } else {
            return (User)res;
        }
    }

    @Override
    public List<User> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<User> userList = em.createQuery("FROM User u").getResultList();
        em.close();
        return userList;
    }

    @Override
    public List<Integer> findUsersIdByRatingDateIsNull() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Integer> userIdList = em.createQuery("SELECT u.id FROM User u WHERE u.id IN" +
                "(SELECT r.user FROM Rating r WHERE ratingDate IS NULL )").getResultList();
        em.close();
        return userIdList;
    }

    @Override
    public void deleteById(Integer userId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, userId));
        em.getTransaction().commit();
        em.close();
    }
}
