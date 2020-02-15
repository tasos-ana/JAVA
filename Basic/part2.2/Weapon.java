package Homework2;

import java.util.Random;

public class Weapon {

    private String name;
    private int strength;

    public Weapon(String name) {
        this.name = name;
        Random rand = new Random();
        strength = rand.nextInt(2)+1;
    }

    public Weapon(String name, int strength) {
        this.name=name;
        this.strength=strength;
    }
    
    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

}
