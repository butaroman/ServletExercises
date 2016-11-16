package com.roman.buta.service.impl;

import com.roman.buta.DAO.RatingDAO;
import com.roman.buta.DAO.UserDAO;
import com.roman.buta.DAO.impl.RatingDAOImpl;
import com.roman.buta.DAO.impl.UserDAOImpl;
import com.roman.buta.model.Rating;
import com.roman.buta.service.RatingService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


public class RatingServiceImpl implements RatingService{

    private RatingDAO ratingDAO;
    private UserDAO userDAO;

    public RatingServiceImpl() {
        this.ratingDAO = new RatingDAOImpl();
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public List<Rating> findAllRatings() {
        return ratingDAO.findAll();
    }

    @Override
    public List<Rating> findAllRatingsAndFixNullDate() {
        List<Integer> userIdList = userDAO.findUsersIdByRatingDateIsNull();
        for(Integer i:userIdList) {
            for(Rating r: ratingDAO.findRatingsWithRatingDateIsNullByUserId(i)) {
                r.setRatingDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
                ratingDAO.saveOrUpdate(r);
            }
        }
        return ratingDAO.findAll();
    }

    @Override
    public List<Object[]> findByRatingOrderByRatingDateAsc(Integer minRating, Integer maxRating) {
        return ratingDAO.findByRatingOrderByRatingDateAsc(minRating, maxRating);
    }

    @Override
    public List<Object[]> findRatingInfo() {
        return ratingDAO.findRatingInfo();
    }

    @Override
    public void deleteRatingById(Integer ratingId) {
        ratingDAO.deleteById(ratingId);
    }
}
