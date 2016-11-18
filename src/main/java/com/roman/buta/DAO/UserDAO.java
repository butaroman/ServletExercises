package com.roman.buta.DAO;

import com.roman.buta.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Integer>{

    List<Integer> findUsersIdByRatingDateIsNull();

}
