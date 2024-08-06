package models.characters.monsters;

import interfaces.IGold;
import interfaces.ILeather;
import tools.Dice;

public class Dragon extends Monster implements ILeather, IGold {

    private int leather;
    private int gold;

    public Dragon(String name) {
        super(name);
        bonusStamina = 1;
        leather = Dice.Dice4.roll();
        gold = Dice.Dice6.roll();
    }

    @Override
    public int getLeather() {
        return leather;
    }

    @Override
    public void setLeather(int leather) {
        this.leather = leather;
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
