package com.roman.buta.service;

import com.roman.buta.model.Movie;

import java.util.List;

public interface MovieService {

    Movie saveOrUpdate(Movie movie);

    Movie findMovieById(Integer movieId);

    List<String> findMoviesTitleByRatingIsNull();

    List<Movie> findAllMovies();

    void deleteMovieById(Integer movieId);
}
