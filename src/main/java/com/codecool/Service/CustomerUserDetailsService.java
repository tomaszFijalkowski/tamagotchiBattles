package com.codecool.Service;

import com.codecool.DAO.UserRepository;
import com.codecool.Entity.CustomerUserDetails;
import com.codecool.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

//        optionalUser.ifPresent(user -> {
//            log.info("Przed mapowaniem: ");
//            log.info("ID " + user.getId());
//            log.info("PASSWORD " + user.getPassword());
//            log.info("USERNAME " + user.getUsername());
//            user.getRoles().forEach(r -> log.info(r.toString()));
//        });


        CustomerUserDetails x = new CustomerUserDetails(optionalUser.get());
        CustomerUserDetails data = optionalUser
                .map(user -> new CustomerUserDetails(user)).get();

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new CustomerUserDetails(optionalUser.get());
//                .map(user -> new CustomerUserDetails(user)).get(); tak było i to jest źle

    }
}
