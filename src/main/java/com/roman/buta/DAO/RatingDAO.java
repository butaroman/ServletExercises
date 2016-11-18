package com.roman.buta.DAO;

import com.roman.buta.model.Rating;
import java.util.List;

public interface RatingDAO extends GenericDAO<Rating, Integer>{

    List<Rating> findRatingsWithRatingDateIsNullByUserId(Integer userId);

    List<Object[]> findByRatingOrderByRatingDateAsc(Integer minRating, Integer maxRating);

    List<Object[]> findRatingInfo();

}
