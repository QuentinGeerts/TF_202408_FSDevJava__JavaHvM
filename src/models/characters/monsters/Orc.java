package models.characters.monsters;

import interfaces.IGold;
import tools.Dice;

public class Orc extends Monster implements IGold {

    private int gold;

    public Orc(String name) {
        super(name);
        bonusStrength = 1;
        gold = Dice.Dice6.roll();
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }
}
