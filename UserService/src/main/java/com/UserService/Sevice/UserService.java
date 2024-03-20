package com.UserService.Sevice;

import com.UserService.Entity.User;

import java.util.List;

public interface UserService {


    List<User> getAllUSer(
            
    );

    void createUser(User user);
}
