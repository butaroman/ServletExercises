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

@WebServlet("/task5")
public class Task5Servlet extends HttpServlet {

    private MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        movieService.deleteMovieById(9);
        movieService.deleteMovieById(10);
        List<Movie> moviesList = movieService.findAllMovies();
        req.setAttribute("moviesList", moviesList);
        req.getRequestDispatcher("movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}

