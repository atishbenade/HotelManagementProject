package com.UserService.Controler;

import com.UserService.Entity.User;
import com.UserService.Sevice.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;

    @PostMapping

    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "user is created";
    }
    @GetMapping
    @CircuitBreaker(name = "ratingService",fallbackMethod = "ratingService")
    @Retry(name = "ratingService",fallbackMethod = "ratingService")
    public ResponseEntity<List<User>> getAllUser(){

        return new ResponseEntity<>(userService.getAllUSer(), HttpStatus.OK);

    }
    private static final Logger logger = LoggerFactory.getLogger(userController.class);
    public ResponseEntity<?>ratingService(Exception exception){
        logger.info("Fall back method is activited",exception.getMessage());
        User user=new User();
        user.setEmail("Dummy@email");
        user.setName("dummy because fall back is activated");
       return new ResponseEntity<>(user,HttpStatus.OK);


    }







}
