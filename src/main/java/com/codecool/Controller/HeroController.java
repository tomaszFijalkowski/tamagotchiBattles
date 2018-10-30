package com.codecool.Controller;

import com.codecool.Entity.Hero;
import com.codecool.Service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    // example GET method endpoint
    @GetMapping("/heroes")
    public List<Hero> getAllHeroes(){
        return heroService.getAllHeroes();
    }

    // example POST method endpoint
    @PostMapping("/heroes")
    public void addHero(@RequestBody Hero hero) {
        heroService.addHero(hero);
    }

}