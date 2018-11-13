//package com.codecool;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class TamagotchiBattlesApp {
//
//    public static void main(String[] args){
//        SpringApplication.run(TamagotchiBattlesApp.class, args);
//
//    }
//}

package com.codecool;

import com.codecool.Entity.Hero;
import com.codecool.Entity.User;
import com.codecool.Enum.ActionType;
import com.codecool.Enum.AttackType;
import com.codecool.Enum.HeroAction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TamagotchiBattlesApp {




    public static void main(String[] args) {
        // *** start BiedaTesting ***
        User user1 = new User("name1", "password1");
        User user2 = new User("name2", "password2");

        Hero hero1 = new Hero("name1", AttackType.WATER, AttackType.EARTH, 5, 5, 5, user1);
        Hero hero2 = new Hero("name2", AttackType.FIRE, AttackType.EARTH, 5, 5, 5, user2);

        Battle battle = new Battle(hero1, hero2);
        // *** end BiedaTesting ***

    }

}
