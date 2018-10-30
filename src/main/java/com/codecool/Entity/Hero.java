package com.codecool.Entity;

import com.codecool.Enum.AttackType;

import javax.persistence.*;

@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private AttackType primaryAttack;
    private AttackType secondaryAttack;

    private int speed;
    private int defense;
    private int attack;

    private int battlesFought = 0;
    private int battlesWon = 0;
    private int experience = 0;

    @ManyToOne
    private User user;

    public Hero() {
    }

    public Hero(String name, AttackType primaryAttack, AttackType secondaryAttack, int speed, int defense, int attack, User user) {
        super();
        this.name = name;
        this.primaryAttack = primaryAttack;
        this.secondaryAttack = secondaryAttack;
        this.speed = speed;
        this.defense = defense;
        this.attack = attack;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttackType getPrimaryAttack() {
        return primaryAttack;
    }

    public void setPrimaryAttack(AttackType primaryAttack) {
        this.primaryAttack = primaryAttack;
    }

    public AttackType getSecondaryAttack() {
        return secondaryAttack;
    }

    public void setSecondaryAttack(AttackType secondaryAttack) {
        this.secondaryAttack = secondaryAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBattlesFought() {
        return battlesFought;
    }

    public void setBattlesFought(int battlesFought) {
        this.battlesFought = battlesFought;
    }

    public int getBattlesWon() {
        return battlesWon;
    }

    public void setBattlesWon(int battlesWon) {
        this.battlesWon = battlesWon;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
