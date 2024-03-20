package com.RatingService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data

@Table(name = "ratingservice")
public class Rating {
    @Id
    private String ratingId;
    private int rating;
    private String HotelId;
    private String userId;
    private String feedback;
    @Transient
    private Hotel hotel;

}
