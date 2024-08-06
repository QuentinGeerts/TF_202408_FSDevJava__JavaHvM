package models.characters.monsters;

import interfaces.ILeather;
import tools.Dice;

public class Wolf extends Monster implements ILeather {

    private int leather;

    public Wolf(String name) {
        super(name);
        leather = Dice.Dice4.roll();
    }

    @Override
    public int getLeather() {
        return leather;
    }

    @Override
    public void setLeather(int leather) {
        this.leather = leather;
    }
}
