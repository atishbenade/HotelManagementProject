package com.HotelService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Hotel")
public class Hotel {
     @Id
    private String hotelId;
    private String name;
    private  String location;
    private String about;
}
