package com.codecool.Controller;

import com.codecool.Entity.Hero;
import com.codecool.Service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/users/{userId}/heroes")
    public ModelAndView getAllHeroesByUserId(@PathVariable int userId, Map<String, Object> model) {
        List<Hero> heroes = heroService.getAllHeroesByUserId(userId);
        model.put("heroes", heroes);
        return new ModelAndView("heroes", model);
    }

    @GetMapping("/users/{userId}/heroes/{heroId}")
    public Hero getHeroById(@PathVariable int heroId) {
        return heroService.getHeroById(heroId);
    }

    @PostMapping("/users/{userId}/heroes")
    public void addHero(@RequestBody Hero hero) {
        heroService.addHero(hero);
    }

    @PutMapping("/users/{userId}/heroes/{heroId}")
    public void updateHero(@RequestBody Hero hero, @PathVariable int heroId) {
        heroService.updateHero(hero);
    }

    @DeleteMapping("/users/{userId}/heroes/{heroId}")
    public void deleteHero(@PathVariable int heroId) {
        heroService.deleteHero(heroId);
    }

}