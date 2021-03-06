package com.roman.buta.controller;

import com.roman.buta.model.Rating;
import com.roman.buta.service.RatingService;
import com.roman.buta.service.impl.RatingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task0ratings")
public class Task0RatingServlet extends HttpServlet {

    private RatingService ratingService = new RatingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equalsIgnoreCase("delete") ) {
            int ratingId = Integer.parseInt( req.getParameter("ratingId") );
            ratingService.deleteRatingById(ratingId);
        }
        List<Rating> ratingsList = ratingService.findAllRatings();
        req.setAttribute("ratingsList", ratingsList);
        req.getRequestDispatcher("rating.jsp").forward(req, resp);
    }
}
