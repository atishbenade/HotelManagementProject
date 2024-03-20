package com.RatingService.Controller;

import com.RatingService.Entity.Rating;
import com.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rating")
public class Controller {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<String>createRating(@RequestBody Rating rating){
        rating.setRatingId(UUID.randomUUID().toString());
        ratingService.createRating(rating);
        return new ResponseEntity<>("your rating created", HttpStatus.CREATED);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Rating>> findByUserId(@PathVariable String userId){
       return new ResponseEntity<>(ratingService.getRatingsUserId(userId), HttpStatus.OK);

    }



}
