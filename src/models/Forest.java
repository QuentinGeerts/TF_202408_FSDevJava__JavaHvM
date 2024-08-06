package models;

import models.characters.Character;
import models.characters.heroes.Dwarf;
import models.characters.heroes.Hero;
import models.characters.heroes.Human;
import models.characters.monsters.Dragon;
import models.characters.monsters.Monster;
import models.characters.monsters.Orc;
import models.characters.monsters.Wolf;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Forest {

    private final String name;
    private final ArrayList<Monster> monsters;
    private Hero hero;

    public Forest(String name) {
        this.name = name;
        this.monsters = new ArrayList<>();
    }

    public void play() {

        // 1. Création du héro
        System.out.println(" --- Création du héro --- ");
        createHero();

        // 2. Génération des monstres
        System.out.println(" --- Génération des monstres --- ");
        generateMonsters();

        // 3. Gestion des combats
        System.out.println(" --- Gestion des combats --- ");
        battles();

    }

    private void battles() {
        for (Monster monster : monsters) {

            System.out.println();
            System.out.println(" --- Combat contre " + monster.getName() + " --- ");
            System.out.println();

            boolean isHeroTurn = true;

            while (hero.isAlive() && monster.isAlive()) {

                showHPBar(hero);
                showHPBar(monster);

                if (isHeroTurn) {
                    hero.hit(monster);
                }
                else {
                    if (monster.isAlive()) monster.hit(hero);
                }

                isHeroTurn = !isHeroTurn;
                System.out.println();
            }

            if (hero.isAlive()) {
                System.out.printf("%s a vaincu %s\n", hero.getName(), monster.getName());
                hero.loot(monster);
                hero.rest();
            }
            else {
                System.out.printf("%s a vaincu %s\n", monster.getName(), hero.getName());
                break;
            }

        }

        if (hero.isAlive()) {
            System.out.println("Vous avez traversé la forêt. :) (gg)");
        }
        else {
            System.out.println("Game Over (RIP)");
        }
    }

    private void showHPBar(Character character) {
        String format = character.getName() + " [";

        for (int i = 0; i < character.getHpMax(); i++) {
            if (i < character.getHp()) format += "◼︎";
            else format += "◻︎";
        }


        format += "]";
        System.out.println(format);
    }

    private void generateMonsters() {
        SecureRandom random = new SecureRandom();
        Monster monster = null;

        for (int i = 0; i < 10; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    monster = new Wolf("Wolfy");
                    break;
                case 1:
                    monster = new Orc("Willy");
                    break;
                case 2:
                    monster = new Dragon("Shenron");
                    break;
            }

            monsters.add(monster);
            System.out.println("Monster: " + monster);
        }
    }

    private void createHero() {

        Scanner scanner = new Scanner(System.in);
        char choice;
        System.out.println("Création du héro:");
        System.out.println("1. Humain | 2. Nain");
        choice = scanner.nextLine().charAt(0);

        while (choice != '1' && choice != '2') {
            System.out.println("Erreur.");
            choice = scanner.nextLine().charAt(0);
        }

        System.out.print("Entrez votre pseudo: ");
        String pseudo = scanner.nextLine();

        switch (choice) {
            case '1':
                hero = new Human(pseudo);
                break;
            case '2':
                hero = new Dwarf(pseudo);
                break;
        }

        System.out.println("Héro créé: \n" + hero);
    }


}
