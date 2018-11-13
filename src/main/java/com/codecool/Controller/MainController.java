package com.codecool.Controller;

import com.codecool.Entity.Room;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class MainController {

    private ArrayList<Room> rooms = new ArrayList<>();

//    @GetMapping("/")
//    public String getProducts(){
//        return "index";
//    }



    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

    private void addTestRooms() {
        rooms.clear();
        rooms.add(new Room("Kurnik"));
        rooms.add(new Room("Stodoła"));
        rooms.add(new Room("Stajnia"));
    }
}