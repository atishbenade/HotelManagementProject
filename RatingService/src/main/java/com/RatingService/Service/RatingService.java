package com.RatingService.Service;

import com.RatingService.Entity.Rating;
import com.RatingService.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {


    @Autowired
    private Repository repository;
    public void createRating(Rating rating) {
        repository.save(rating);
    }

    public List<Rating> getRatingsUserId(String userId) {

        List<Rating> found = repository.findByuserId(userId).orElseThrow(() -> new RuntimeException("not found"));

    return found;
    }
}
