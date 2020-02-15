package Homework2;

public abstract class Entity {

    private String name;
    private int health;
    private int strength;
    private Weapon weapon;

    public Entity(String name) { //dimiourgei instance name=name, health=10
        this.name=name;
        this.health=10;
    }
    
    //public Entity(){};

    public boolean isAlive() {
        return this.health != 0;
    }

    public void setHealth(int health) {//orizei nea timi gia to health
        this.health = health;
    }

    public void setStrength(int strength) {// orizei nea dinami
        this.strength = strength;
    }

    public void setWeapon(Weapon weapon) {//orizei neo oplo
        this.weapon = weapon;
    }

    public String getName() {//epistrefei to name
        return name;
    }

    public int getHealth() {// epistrefei to health
        return health;
    }

    public int getStrength() {//epistrefei tin dinami
        return strength;
    }

    public Weapon getWeapon() {//epistrefei to weapon
        return weapon;
    }

    public abstract String toString(); //epistrefei tin anaparastasi tis ontotitas ws simvoloseira

    public boolean wonBattle(Entity adversary) {
        return this.health != 0 && adversary.health == 0;
    }

    public boolean isStrongerThan(Entity adversary) {
        return this.strength > adversary.strength;
    }

}
