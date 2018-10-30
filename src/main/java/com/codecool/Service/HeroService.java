package com.codecool.Service;

import com.codecool.DAO.HeroRepository;
import com.codecool.Entity.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    // example service method
    public List<Hero> getAllHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroRepository.findAll().forEach(heroes::add);
        return heroes;
    }

    // example service method
    public void addHero(Hero hero) {
        heroRepository.save(hero);
    }

}
