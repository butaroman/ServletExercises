package com.roman.buta.controller;

import com.roman.buta.service.MovieService;
import com.roman.buta.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task4")
public class Task4Servlet extends HttpServlet {

    private MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> movieTitleList = movieService.findMoviesTitleByRatingIsNull();
        req.setAttribute("movieTitleList", movieTitleList);
        req.getRequestDispatcher("movieTitle.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
