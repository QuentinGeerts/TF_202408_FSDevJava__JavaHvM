package tools;

import java.security.SecureRandom;

public enum Dice {
    Dice4(4),
    Dice6(6);

    private int minimum;
    private int maximum;
    private SecureRandom random;

    Dice(int maximum) {
        this.minimum = 1;
        this.maximum = maximum;
        this.random = new SecureRandom();
    }

    public int roll() {
        return random.nextInt(maximum) + minimum;
    }
}
