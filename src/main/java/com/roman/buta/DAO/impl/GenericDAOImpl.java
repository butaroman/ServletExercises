package com.roman.buta.DAO.impl;


import com.roman.buta.DAO.GenericDAO;
import com.roman.buta.config.JPAUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K>{

    private final Class<T> entityClass;

    public GenericDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public T saveOrUpdate(T entity) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        T t = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public T findById(K id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        T t = em.find(this.entityClass, id);
        em.close();
        return t;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<T> tList = em.createQuery("FROM " + this.entityClass.getSimpleName()).getResultList();
        em.close();
        return tList;
    }

    @Override
    public void deleteById(K id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        T t = em.find(this.entityClass, id);
        if(t != null) {
            em.remove(t);
        }
        em.getTransaction().commit();
        em.close();
    }
}
