package com.UserService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private int rating;
    private String userId;
    private String hotelId;
    private String feedBack;
    public Hotel hotel;



}
