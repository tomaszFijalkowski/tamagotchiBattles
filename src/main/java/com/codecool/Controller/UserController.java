package com.codecool.Controller;

import com.codecool.Service.UserDto;
import com.codecool.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // example GET method endpoint
//    @GetMapping("/users")
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }

    // example POST method endpoint
    @PostMapping("/users")
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }
}
