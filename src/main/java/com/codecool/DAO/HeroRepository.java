package com.codecool.DAO;

import com.codecool.Entity.Hero;
import org.springframework.data.repository.CrudRepository;


public interface HeroRepository extends CrudRepository<Hero, String>{

}
