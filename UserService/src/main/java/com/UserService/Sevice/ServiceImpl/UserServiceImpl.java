package com.UserService.Sevice.ServiceImpl;

import com.UserService.Entity.Hotel;
import com.UserService.Entity.Rating;
import com.UserService.Entity.User;
import com.UserService.PayLoad.HotelBYHotelId;
import com.UserService.PayLoad.RatingForUsers;
import com.UserService.Repository.UserRepository;
import com.UserService.Sevice.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
    @Autowired
    HotelBYHotelId hotelBYHotelId;
    @Override
    public void createUser(User user) {

        user.setUserId(UUID.randomUUID().toString());

        userRepository.save(user);
    }
    @Autowired
    private RatingForUsers ratingForUsers;
    @Override

    public List<User> getAllUSer() {

        List<User> users = userRepository.findAll();

        List<User> All = users.stream().map(user -> {

            List<Rating> ratings = ratingForUsers.ratingByUser(user.getUserId());


            List<Rating> collect = ratings.stream().map(rating -> {
                Hotel hotel = hotelBYHotelId.hotelById(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;  }).collect(Collectors.toList());

            user.setRatings(collect);
            return user;}).collect(Collectors.toList());

             return All;
    }


    //cerating fall back method

}
