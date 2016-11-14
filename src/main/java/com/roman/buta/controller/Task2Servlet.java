package com.roman.buta.controller;

import com.roman.buta.model.Movie;
import com.roman.buta.service.MovieService;
import com.roman.buta.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task2")
public class Task2Servlet extends HttpServlet {

    private MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Movie m1 = new Movie(9, "Deadpool", "Tim Miller");
        Movie m2 = new Movie(10, "The 300 spartans", "Zak Snyder");
        movieService.saveOrUpdate(m1);
        movieService.saveOrUpdate(m2);
        List<Movie> moviesList = movieService.findAllMovies();
        req.setAttribute("moviesList", moviesList);
        req.getRequestDispatcher("movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
