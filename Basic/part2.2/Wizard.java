package Homework2;

import java.util.Random;

public class Wizard extends Entity implements Playable {

    private int spellStrength;

    public Wizard(String name) {//dimiourgeia tou magou
        super(name);
        super.setStrength(4);
        Random rand = new Random();
        spellStrength = rand.nextInt(4)+1;
    }

    public void castSpell(Entity adversary) {//epithesi me ksorki       
        if (adversary.getHealth() - (spellStrength + this.getStrength() + this.getWeapon().getStrength()) < 0) {//elegxoume an i zwi pou exei eparkei oste na tou kanei olokliri tin zimia
            adversary.setHealth(0);
        } else {
            adversary.setHealth(adversary.getHealth() - (spellStrength + this.getStrength() + this.getWeapon().getStrength()));
        }
    }

    public int getSpellStrength() {
        return spellStrength;
    }

    public void setSpellStrength(int spellStrength) {
        this.spellStrength = spellStrength;
    }

    public boolean hasWand() {
        return this.getWeapon() != null && "Wand".equals(this.getWeapon().getName());//epistrefoume true otan exei oplo kai afto einai wand
    }

   @Override
    public String toString() {
        String fName, fPassive, fHealth, fStrength, fWeapon;
        fName = "Wizard: " + this.getName() + "\n";
        fPassive = "Spell strength: " + this.getSpellStrength() + "\n";
        fHealth = "Health: " + this.getHealth() + "\n";
        fStrength = "Strength: " + this.getStrength() + "\n";
        if (this.getWeapon() != null) {
            fWeapon = "Weapon: name: " + this.getWeapon().getName() + ", strength: " + this.getWeapon().getStrength() + "\n";
        } else {
            fWeapon = "No weapon.\n";
        }
        return fName + fPassive + fHealth + fStrength + fWeapon + "\n";
    }

    @Override
    public void attack(Entity adversary) {
        if (this.isAlive() && adversary.isAlive()) {
            if (this.hasWand()) {
                this.castSpell(adversary);
            } else {
                if (adversary.getHealth() - (spellStrength + this.getStrength()) < 0) {//elegxoume an i zwi pou exei eparkei oste na tou kanei olokliri tin zimia
                    adversary.setHealth(0);
                } else {
                    adversary.setHealth(adversary.getHealth() - (spellStrength + this.getStrength()));
                }
            }
        }
    }

    @Override
    public void defend(Entity adversary) {
        if (this.isAlive() && adversary.isAlive()) {
            if (adversary.getWeapon()!= null) {
                if ((this.getHealth() - (adversary.getStrength() + adversary.getWeapon().getStrength())) > 0) {
                       this.setHealth(this.getHealth() - (adversary.getStrength() + adversary.getWeapon().getStrength()));
                }
                else{
                    this.setHealth(0);
                }
            }
            else{
                if ((this.getHealth() - (adversary.getStrength())) > 0) {
                       this.setHealth(this.getHealth() - (adversary.getStrength()));
                }
                else{
                    this.setHealth(0);
                }
            }
        }
    }
}
