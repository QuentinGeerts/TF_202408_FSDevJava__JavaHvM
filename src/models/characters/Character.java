package models.characters;

import interfaces.ICharacters;
import tools.Dice;

import java.util.Arrays;

public class Character implements ICharacters {

    private final String name;
    private final int strength;
    private final int stamina;
    private int hp;
    private final int hpMax;

    protected int bonusStrength;
    protected int bonusStamina;

    public Character(String name) {
        this.name = name;
        strength = generateStat();
        stamina = generateStat();
        hp = hpMax = getStamina() + modifier(getStamina());
    }

    private int modifier(int stat) {
        if (stat < 5) return -1;
        else if (stat < 10) return 0;
        else if (stat < 15) return 1;
        else return 2;
    }

    private int generateStat() {
        int[] stats = new int[4];

        for (int i = 0; i < stats.length; i++) {
            stats[i] = Dice.Dice6.roll();
        }

        Arrays.sort(stats);

        return stats[1] + stats[2] + stats[3];
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength + bonusStrength;
    }

    public int getStamina() {
        return stamina + bonusStamina;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public void hit(Character target) {
        int damage = Dice.Dice4.roll() + modifier(getStrength());
        target.hp -= damage;

        System.out.printf("%s infige %d points de dégâts à %s\n", getName(), damage, target.getName());
    }

    protected void resetHp() {
        hp = hpMax;
    }

    @Override
    public String toString() {
        return "race: " + this.getClass().getSimpleName() +
                ", name = '" + name + '\'' +
                "\nCaractéristiques : strength = " + strength +
                ", stamina = " + stamina +
                ", hp = " + hp +
                ", hpMax = " + hpMax +
                ", bonusStrength = " + bonusStrength +
                ", bonusStamina = " + bonusStamina;
    }
}
