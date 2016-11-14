package com.roman.buta.DAO;

import com.roman.buta.model.Rating;
import java.util.List;

public interface RatingDAO {

    Rating saveOrUpdate(Rating rating);

    List<Rating> findAll();

    List<Rating> findRatingsWithRatingDateIsNullByUserId(Integer userId);

    List<Object[]> findByRatingOrderByRatingDateAsc(Integer minRating, Integer maxRating);

    List<Object[]> findRatingInfo();
}
