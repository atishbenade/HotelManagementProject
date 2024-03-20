package com.UserService.Controler;

import com.UserService.Entity.User;
import com.UserService.Sevice.UserService;
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
    public ResponseEntity<List<User>> getAllUser(){

        return new ResponseEntity<>(userService.getAllUSer(), HttpStatus.OK);

    }







}
