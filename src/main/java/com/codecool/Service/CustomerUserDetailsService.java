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

        System.out.println("Przed mapowaniem: ");
        System.out.println("ID " + optionalUser.get().getId());
        System.out.println("PASSWORD " + optionalUser.get().getPassword());
        System.out.println("USERNAME " + optionalUser.get().getUsername());


        System.out.println("ROLE " + optionalUser.get().getRoles().toArray()[0]);

        CustomerUserDetails data = optionalUser
                .map(CustomerUserDetails::new).get();           // MAP WAS A MISTAKE AS WE HAVE ONLY ONE USER

        System.out.println("Po mapowaniu: ");
        System.out.println("ID " + data.getId());
        System.out.println("PASSWORD " + data.getPassword());
        System.out.println("USERNAME " + data.getUsername());

        optionalUser
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return new CustomerUserDetails(optionalUser.get());
//                .map(user -> new CustomerUserDetails(user)).get(); tak było i to jest źle

    }
}
