package Homework2;

public class Troll extends Entity {

    public Troll(String name) {
        super(name);
        super.setStrength(8);
    }

    @Override
    public String toString() {
        String fName, fHealth, fStrength, fWeapon;
        fName = "Troll: " + this.getName() + "\n";
        fHealth = "Health: " + this.getHealth() + "\n";
        fStrength = "Strength: " + this.getStrength() + "\n";
        if (this.getWeapon() != null) {
            fWeapon = "Weapon: name: " + this.getWeapon().getName() + ", strength: " + this.getWeapon().getStrength() + "\n";
        } else {
            fWeapon = "No weapon.\n";
        }
        return fName + fHealth + fStrength + fWeapon + "\n";
    }

//    @Override
//    public void attack(Entity adversary) {
//        if (this.isAlive() && adversary.isAlive()) {
//            if (this.getWeapon() != null) {
//                if (adversary.getHealth() - (this.getWeapon().getStrength() + this.getStrength()) < 0) {//elegxoume an i zwi pou exei eparkei oste na tou kanei olokliri tin zimia
//                    adversary.setHealth(0);
//                } else {
//                    adversary.setHealth(adversary.getHealth() - (this.getWeapon().getStrength() + this.getStrength()));
//                }
//            } else {
//                if (adversary.getHealth() - (this.getStrength()) < 0) {//elegxoume an i zwi pou exei eparkei oste na tou kanei olokliri tin zimia
//                    adversary.setHealth(0);
//                } else {
//                    adversary.setHealth(adversary.getHealth() - (this.getStrength()));
//                }
//            }
//        }
//    }
//
//    @Override
//    public void defend(Entity adversary) {
//        if (this.isAlive() && adversary.isAlive()) {
//            if (adversary.getWeapon() != null) {
//                if (this.getHealth() > (adversary.getStrength() + adversary.getWeapon().getStrength())) {
//                    this.setHealth(this.getHealth() - (adversary.getStrength() + adversary.getWeapon().getStrength()));
//                } else {
//                    this.setHealth(0);
//                }
//            } else {
//                if (this.getHealth() > (adversary.getStrength())) {
//                    this.setHealth(this.getHealth() - (adversary.getStrength()));
//                } else {
//                    this.setHealth(0);
//                }
//            }
//        }
//    }
}
