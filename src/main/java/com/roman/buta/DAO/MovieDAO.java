package com.roman.buta.DAO;

import com.roman.buta.model.Movie;

import java.util.List;

public interface MovieDAO extends GenericDAO<Movie, Integer>{

    List<String> findMoviesTitleByRatingIsNull();

}
