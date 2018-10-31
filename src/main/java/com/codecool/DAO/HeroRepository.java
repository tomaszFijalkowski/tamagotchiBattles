package com.codecool.DAO;

import com.codecool.Entity.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HeroRepository extends CrudRepository<Hero, String>{

    List<Hero> findByUserId(Long userId);
    Hero findById(Long id);
    void deleteById(Long id);
}
