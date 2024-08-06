package models.characters.heroes;

import interfaces.IGold;
import interfaces.IHeroes;
import interfaces.ILeather;
import models.characters.Character;
import models.characters.monsters.Monster;

public class Hero extends Character implements IHeroes, IGold, ILeather {

    private int gold;
    private int leather;

    public Hero(String name) {
        super(name);
    }

    @Override
    public void loot(Monster monster) {
        if (monster instanceof IGold) {
            gold += ((IGold)monster).getGold();
        }

        if (monster instanceof ILeather) {
            leather += ((ILeather)monster).getLeather();
        }
    }

    @Override
    public void rest() {
        resetHp();
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
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
    public String toString() {
        return super.toString()
                + "\nInventaire: "
                + " Gold: " + gold
                + " Leather: " + leather + "\n";
    }
}
