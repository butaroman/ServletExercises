package com.roman.buta.service;

import com.roman.buta.model.Rating;
import java.util.List;


public interface RatingService {

    List<Rating> findAllRatings();

    List<Rating> findAllRatingsAndFixNullDate();

    List<Object[]> findByRatingOrderByRatingDateAsc(Integer minRating, Integer maxRating);

    List<Object[]> findRatingInfo();

    void deleteRatingById(Integer ratingId);
}
