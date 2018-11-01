package com.codecool.Entity;

import java.util.ArrayList;

public class Room {


    private String name;
    private ArrayList<User> usersInRoom = new ArrayList<>();
    private int fulfillment = 0;

    public Room(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsersInRoom() {
        return usersInRoom;
    }

    public boolean isRoomFull() {
        return usersInRoom.size() >= 2;
    }

    public void addUserToRoom(User user) {
        if (isRoomFull()) {
            usersInRoom.add(user);
            fulfillment++;
        }
    }

    public void removeUserFromRoom(User user) {
        usersInRoom.remove(user);
        fulfillment--;
    }

    public String getName() {
        return name;
    }
}
