package com.niafikra.internship.justlist.service;

import com.niafikra.internship.justlist.data.User;

/**
 * Created by lilianngweta on 6/27/16.
 */
public class UserService {

    private static UserService userService;

    public static UserService get(){
        if(userService == null)
            userService = new UserService();

        return userService;
    }

    public boolean register(User user) {
        return true;
    }
}