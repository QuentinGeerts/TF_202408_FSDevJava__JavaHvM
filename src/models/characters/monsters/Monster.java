package models.characters.monsters;

import interfaces.IGold;
import interfaces.ILeather;
import models.characters.Character;

public class Monster extends Character {
    public Monster(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nInventaire:"
                + ((this instanceof IGold) ? " Gold: " + ((IGold) this).getGold() : "")
                + ((this instanceof ILeather) ? " Leather: " + ((ILeather) this).getLeather() : "")
                + "\n";
    }
}
