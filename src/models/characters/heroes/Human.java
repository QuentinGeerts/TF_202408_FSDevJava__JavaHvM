package models.characters.heroes;

public class Human extends Hero {
    public Human(String name) {
        super(name);
        bonusStamina = 1;
        bonusStrength = 1;
    }
}
