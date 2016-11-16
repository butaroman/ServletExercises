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


@WebServlet("/task0movies")
public class Task0MovieServlet extends HttpServlet {

    private MovieService movieService = new MovieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equalsIgnoreCase("delete") ) {
            int movieId = Integer.parseInt( req.getParameter("movieId") );
            movieService.deleteMovieById(movieId);
        }
        req.setAttribute("moviesList", movieService.findAllMovies());
        req.getRequestDispatcher("movie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Movie movie = new Movie();
        if(!req.getParameter("id").equals("")) {
            movie.setId(Integer.parseInt(req.getParameter("id")));
            movie.setTitle(req.getParameter("title"));
            movie.setDirector(req.getParameter("director"));
            movieService.saveOrUpdate(movie);
        }
        req.setAttribute("moviesList", movieService.findAllMovies());
        req.getRequestDispatcher("movie.jsp").forward(req, resp);
    }
}
