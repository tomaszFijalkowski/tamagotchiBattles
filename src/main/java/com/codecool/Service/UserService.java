package com.codecool.Service;

import com.codecool.DAO.UserRepository;
import com.codecool.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    public void addUser(UserDto userDto) {
        UserDetails details = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username(userDto.getUsername()).password(userDto.getPassword()).roles("USER").build();
        userRepository.save(new User(userDto.getUsername(), details.getPassword()));
    }

}

//        userRepository.save(new User(userDto.getUsername(), "{noop}" + userDto.getPassword()));

