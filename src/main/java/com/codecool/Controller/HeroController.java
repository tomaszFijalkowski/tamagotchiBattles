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

    @GetMapping("/users/{userId}/heroes")
    public List<Hero> getAllHeroesByUserId(@PathVariable Long userId){
        return heroService.getAllHeroesByUserId(userId);
    }

    @GetMapping("/users/{userId}/heroes/{heroId}")
    public Hero getHeroById(@PathVariable Long heroId){
        return heroService.getHeroById(heroId);
    }

    @PostMapping("/users/{userId}/heroes")
    public void addHero(@RequestBody Hero hero) {
        heroService.addHero(hero);
    }

    @PutMapping("/users/{userId}/heroes/{heroId}")
    public void updateHero(@RequestBody Hero hero, @PathVariable Long heroId) {
        heroService.updateHero(hero);
    }

    @DeleteMapping("/users/{userId}/heroes/{heroId}")
    public void deleteHero(@PathVariable Long heroId){
        heroService.deleteHero(heroId);
    }

}