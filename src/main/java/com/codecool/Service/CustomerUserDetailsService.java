package com.codecool.Service;

import com.codecool.DAO.UserRepository;
import com.codecool.Entity.CustomerUserDetails;
import com.codecool.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        optionalUser
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return optionalUser
//                .map(user -> new CustomerUserDetails(user)).get(); chyba to samo co linijka ponizej
        .map(CustomerUserDetails::new).get();

    }
}
