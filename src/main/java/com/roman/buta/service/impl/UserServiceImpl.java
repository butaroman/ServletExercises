package com.roman.buta.service.impl;

import com.roman.buta.DAO.UserDAO;
import com.roman.buta.DAO.impl.UserDAOImpl;
import com.roman.buta.model.User;
import com.roman.buta.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }
}
