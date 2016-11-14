package com.roman.buta.controller;

import com.roman.buta.service.RatingService;
import com.roman.buta.service.impl.RatingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task3")
public class Task3Servlet extends HttpServlet {

    private RatingService ratingService = new RatingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> resultList = ratingService.findByRatingOrderByRatingDateAsc(4, 5);
        req.setAttribute("resultList", resultList);
        req.getRequestDispatcher("movieInfo.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
