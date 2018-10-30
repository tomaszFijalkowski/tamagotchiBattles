package com.codecool.Service;

import com.codecool.DAO.UserRepository;
import com.codecool.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // example service method
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    // example service method
    public void addUser(User user) {
        userRepository.save(user);
    }

}
