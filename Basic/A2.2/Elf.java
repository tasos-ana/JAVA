package Homework2;

public class Elf extends Entity implements Playable {

    private boolean visible;

    public Elf(String name) {
        super(name);
        super.setStrength(6);
        this.visible = true;
    }

    public void becomeVisible() {
        this.visible = true;
    }

    public void becomeInvisible() {
        this.visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public void attack(Entity adversary) {
        if (this.isAlive() && adversary.isAlive()) {
            if (this.getWeapon()!= null) {
                if (adversary.getHealth() - (this.getWeapon().getStrength() + this.getStrength()) < 0) {//elegxoume an i zwi pou exei eparkei oste na tou kanei olokliri tin zimia
                    adversary.setHealth(0);
                } else {
                    adversary.setHealth(adversary.getHealth() - (this.getWeapon().getStrength() + this.getStrength()));
                }
            } else {
                if (adversary.getHealth() - (this.getStrength()) < 0) {//elegxoume an i zwi pou exei eparkei oste na tou kanei olokliri tin zimia
                    adversary.setHealth(0);
                } else {
                    adversary.setHealth(adversary.getHealth() - (this.getStrength()));
                }
            }
        }
    }

    @Override
    public void defend(Entity adversary) {
        if (this.isAlive() && adversary.isAlive()) {
            if (this.isVisible()) {
                this.becomeInvisible();
            } else {
                if (adversary.getWeapon()!= null) {
                    if (this.getHealth() > (adversary.getStrength() + adversary.getWeapon().getStrength())) {//elegxoume an h zwi pou exei einai>= tis dimias pou tha kanei
                        this.setHealth(this.getHealth() - (adversary.getStrength() + adversary.getWeapon().getStrength()));
                    } else {
                        this.setHealth(0);
                    }
                } else {
                    if (this.getHealth() > (adversary.getStrength())) {
                        this.setHealth(this.getHealth() - (adversary.getStrength()));
                    } else {
                        this.setHealth(0);
                    }
                }
                this.becomeVisible();
            }
        }
    }

    @Override
    public String toString() {
        String fName, fPassive, fHealth, fStrength, fWeapon;
        fName = "Elf: " + this.getName() + "\n";
        fPassive = "Visible: " + this.isVisible() + "\n";
        fHealth = "Health: " + this.getHealth() + "\n";
        fStrength = "Strength: " + this.getStrength() + "\n";
        if (this.getWeapon() != null) {
            fWeapon = "Weapon: name: " + this.getWeapon().getName() + ", strength: " + this.getWeapon().getStrength() + "\n";
        } else {
            fWeapon = "No weapon.\n";
        }
        return fName + fPassive + fHealth + fStrength + fWeapon + "\n";
    }

}
