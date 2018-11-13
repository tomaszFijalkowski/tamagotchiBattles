package com.codecool.Service;

import com.codecool.DAO.HeroRepository;
import com.codecool.Entity.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> getAllHeroesByUserId(int userId) {
        return new ArrayList<>(heroRepository.findByUserId(userId));
    }

    public Hero getHeroById(int heroId) {
        return heroRepository.findById(heroId);
    }

    public void addHero(Hero hero) {
        heroRepository.save(hero);
    }

    public void updateHero(Hero hero) {
        heroRepository.save(hero);
    }

    @Transactional
    public void deleteHero(int heroId) {
        heroRepository.deleteById(heroId);
    }
}
