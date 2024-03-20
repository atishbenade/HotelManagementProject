package com.HotelService.Service;

import com.HotelService.Entity.Hotel;
import com.HotelService.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
       return hotelRepository.save(hotel);

    }


    public Hotel getByHotelId(String hotelId){
        return hotelRepository.findById(hotelId).orElseThrow(()-> new RuntimeException("Not found"));

    }
}
