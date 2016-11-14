package com.roman.buta.DAO;

import com.roman.buta.model.User;
import java.util.List;

public interface UserDAO {

    User findById(Integer userId);

    List<User> findAll();

    List<Integer> findUsersIdByRatingDateIsNull();

}
