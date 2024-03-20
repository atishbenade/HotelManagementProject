package com.UserService.PayLoad;

import com.UserService.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingForUsers {

    @GetMapping("/rating/user/{userId}")
    List<Rating>ratingByUser(@PathVariable String userId);




}
