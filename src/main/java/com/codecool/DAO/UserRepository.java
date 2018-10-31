package com.codecool.DAO;

import com.codecool.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}

