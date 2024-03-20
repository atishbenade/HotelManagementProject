package com.RatingService.Repository;

import com.RatingService.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Rating,String> {
    Optional<List<Rating>> findByuserId(String userId);
}
