package com.roman.buta.DAO;
import java.util.List;

public interface GenericDAO <T, K> {

    T saveOrUpdate(T entity);

    T findById(K id);

    List<T> findAll();

    void deleteById(K id);

}
