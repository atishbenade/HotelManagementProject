package com.UserService.PayLoad;

import com.UserService.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelBYHotelId {

    @GetMapping("/hotel/{hotelId}")
    Hotel hotelById(@PathVariable String hotelId);
}
