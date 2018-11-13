package com.codecool;

import com.codecool.Entity.Hero;
import com.codecool.Enum.ActionType;
import com.codecool.Enum.AttackType;
import com.codecool.Enum.HeroAction;

import java.util.Scanner;

public class Battle {
    int maxHeroHealth = 100;
    Hero hero1;
    Hero hero2;
    HeroAction choice1;
    HeroAction choice2;
    int hero1Hp = maxHeroHealth;
    int hero2Hp = maxHeroHealth;


    // *** start scanner for test  ***
    static Scanner reader = new Scanner(System.in);
    // *** end scanner for test  ***


    public Battle(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }


    public void startBattle() {

    //TODO write view for getting user input (ask4UserInput)


        while (hero1Hp > 0 && hero2Hp > 0 ) {
        //** ASK USERS FOR INPUT. SOMEHOW DEMANDS THE FASTEST HERO OWNER TO ANSWER FIRST (SORRY!) ***
        System.out.println("User1:\n");
        choice1 = HeroAction.getAction(ask4UserInput());
        System.out.println("User2:\n");
        choice2 = HeroAction.getAction(ask4UserInput());
        //*** FINISH ASKING FOR INPUT ***

        // ACTUAL FIGHT. ONE ROUND
        singleRound();

    }

    // add experience points to heroes. Experience points == hero's health left
        hero1.addExperience(hero1Hp);
        hero2.addExperience(hero2Hp);

    // increase battles fought by one
        hero1.increaseBattlesFought();
        hero2.increaseBattlesFought();

}



    public void singleRound(){

        if (choice1.getActionType() != ActionType.ATTACK && choice2.getActionType() != ActionType.ATTACK) {
            //both players are defending / evading and nothing happens
        } else {

            if (choice1.getActionType() == ActionType.ATTACK && choice2.getActionType() == ActionType.ATTACK) {
                resolveTwoAttacks();
            }
            if (choice1 == HeroAction.DEFEND || choice2 == HeroAction.DEFEND) {
                resolveAttackDefense();
            }

            if (choice1 == HeroAction.EVADE || choice2 == HeroAction.EVADE) {
                //resolve 1 attack 1 evade
            }

        }

    }



    public void resolveTwoAttacks() {
    }

    public void resolveAttackDefense() {
        double attackValue;
        double defense;

        if (choice1.getActionType() == ActionType.ATTACK) {
            attackValue = countAttackValue(hero1, hero2, choice1);
            defense = hero2.getDefense() *2;
            hero2Hp -= (attackValue - defense);
        }
        else {
            attackValue = countAttackValue(hero2, hero1, choice2);
            defense = hero1.getDefense() * 2;
            hero1Hp -= (attackValue - defense);
        }

    }



    public double countAttackValue(Hero attackingHero, Hero defendingHero, HeroAction attackingAction) {
        double modifier;
        double attack;
        attack = attackingHero.getAttack() * ((attackingAction == HeroAction.PRIMARY_ATTACK) ? 1 : 0.75); //primary value

        if (attackingAction == HeroAction.PRIMARY_ATTACK) {
           modifier = countModifier(attackingHero.getPrimaryAttack(), defendingHero.getPrimaryAttack());
       }    else {
            modifier = countModifier(attackingHero.getSecondaryAttack(), defendingHero.getPrimaryAttack());
        }

        return attack * modifier;
    }


    // autentycznie nie wiem, jak napisać bardziej czytelną funkcję. No nie i chuj.
    public double countModifier(AttackType attackingHeroType, AttackType defendingHeroType) {
        if (attackingHeroType == defendingHeroType) {
            return 1;
        }

        if ( (attackingHeroType == AttackType.FIRE && defendingHeroType == AttackType.EARTH) ||
                (attackingHeroType == AttackType.EARTH && defendingHeroType == AttackType.WATER) ||
                (attackingHeroType == AttackType.WATER && defendingHeroType == AttackType.FIRE)) {
                return 1.25;
        }

        else return 0.75;

    }



    // *** only for tests and console input ***
    public int ask4UserInput() {
        System.out.println("Choose your hero's attack:\n0/ primary attack\n1/ secondary attack \n2/ defend \n3/ evade");
        String input = reader.nextLine();
        int chosenAttack = Integer.parseInt(input);

        return chosenAttack;
    }


}
