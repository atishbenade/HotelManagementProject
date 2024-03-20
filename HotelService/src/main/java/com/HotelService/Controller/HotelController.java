package com.HotelService.Controller;

import com.HotelService.Entity.Hotel;
import com.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;


    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.createHotel(hotel);

    }

    @GetMapping("/{hotelId}")
    public Optional<Hotel> findByHotelId(@PathVariable String hotelId){
        return hotelService.getByHotelId(hotelId);
    }



}
