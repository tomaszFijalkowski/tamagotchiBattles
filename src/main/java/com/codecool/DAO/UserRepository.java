package com.codecool.DAO;

import com.codecool.Entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String>{

}
