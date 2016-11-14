package com.roman.buta.DAO;

import com.roman.buta.model.Movie;
import java.util.List;

public interface MovieDAO {

    Movie saveOrUpdate(Movie movie);

    List<String> findMoviesTitleByRatingIsNull();

    Movie findById(Integer movieId);

    List<Movie> findAll();

    void deleteById(Integer movieId);
}
