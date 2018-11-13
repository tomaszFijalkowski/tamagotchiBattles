package com.codecool.DAO;

import com.codecool.Entity.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HeroRepository extends CrudRepository<Hero, String>{

    List<Hero> findByUserId(int userId);

    Hero findById(int id);
    void deleteById(int id);
}
