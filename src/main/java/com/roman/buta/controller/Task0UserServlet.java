package com.roman.buta.controller;

import com.roman.buta.service.UserService;
import com.roman.buta.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task0users")
public class Task0UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equalsIgnoreCase("delete") ) {
            int userId = Integer.parseInt( req.getParameter("userId") );
            userService.deleteUserById(userId);
        }
        req.setAttribute("usersList", userService.findAllUsers());
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

}
