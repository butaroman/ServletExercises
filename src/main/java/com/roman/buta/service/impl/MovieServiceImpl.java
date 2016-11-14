package com.roman.buta.service.impl;

import com.roman.buta.DAO.MovieDAO;
import com.roman.buta.DAO.impl.MovieDAOImpl;
import com.roman.buta.model.Movie;
import com.roman.buta.service.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService{

    private MovieDAO movieDAO;

    public MovieServiceImpl() {
        movieDAO = new MovieDAOImpl();
    }

    @Override
    public Movie saveOrUpdate(Movie movie) {
        return movieDAO.saveOrUpdate(movie);
    }

    @Override
    public Movie findMovieById(Integer movieId) {
        return movieDAO.findById(movieId);
    }

    @Override
    public List<String> findMoviesTitleByRatingIsNull() {
        return movieDAO.findMoviesTitleByRatingIsNull();
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieDAO.findAll();
    }

    @Override
    public void deleteMovieById(Integer movieId) {
        movieDAO.deleteById(movieId);
    }
}
