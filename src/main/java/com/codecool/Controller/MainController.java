package com.codecool.Controller;

import com.codecool.Entity.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;


@Controller
public class MainController {

    private ArrayList<Room> rooms = new ArrayList<>();

    @GetMapping("/")
    public ModelAndView home(Map<String, Object> model) {
        addTestRooms();
        for (Room room : rooms) {
            model.put(room.getName(), room.getUsersInRoom());
        }
        return new ModelAndView("index", model);
    }

    @GetMapping("/home")
    public String showRooms() {
        return "redirect:/";
    }


    private void addTestRooms() {
        rooms.clear();
        rooms.add(new Room("Kurnik"));
        rooms.add(new Room("Stodoła"));
        rooms.add(new Room("Stajnia"));
    }
}