package Homework2;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private static List<Entity> createPlayers() {
        List<Entity> players = new ArrayList<>();
        Wizard wiz = new Wizard("Pallando");
        players.add(wiz);
        Elf elf = new Elf("Orodreth");
        Weapon sword = new Weapon("sword");
        elf.setWeapon(sword);
        players.add(elf);
        Troll troll = new Troll("Rogash");
        players.add(troll);
        Orc orc = new Orc("Bolg");
        Weapon sword2 = new Weapon("sword");
        orc.setWeapon(sword2);
        orc.setLeader(troll);
        players.add(orc);
        Entity wiz2 = new Wizard("Alatar");
        Weapon wand = new Weapon("wand");
        wiz2.setWeapon(wand);
        players.add(wiz2);
        return players;
    }

    public static void main(String[] args) {
        List<Entity> players = createPlayers();
        System.out.println("Created the following players:\n");
        for (Entity entity : players) {
            System.out.print(entity.toString());
        }
        Wizard e0 = (Wizard) players.get(0);
        Elf e1 = (Elf) players.get(1);
        if (e0.isStrongerThan(e1)) {
            System.out.println(e0.getName() + " is stronger than " + e1.getName());
        } else {
            System.out.println(e0.getName() + " is not stronger than " + e1.getName());
        }
        Orc e3 = (Orc) players.get(3);
        Wizard e4 = (Wizard) players.get(4);
        Troll leader = e3.getLeader();
        System.out.println("\nBattle between " + e4.getName() + " and " + e3.getName() + "!");
        while (!e4.wonBattle(e3) && !e3.wonBattle(e4)) {
            System.out.print(e4.getName() + "'s health:" + e4.getHealth() + ", ");
            System.out.println(e3.getName() + "'s health:" + e3.getHealth());
            try {
                e4.attack(e3);
                System.out.println(e4.getName() + " just attacked " + e3.getName());
                System.out.println(e3.getName() + "'s health:" + e3.getHealth());
                e4.defend(e3);
                System.out.println(e3.getName() + " just attacked " + e4.getName());
                System.out.println(e4.getName() + "'s health:" + e4.getHealth());
                if (leader != null) {
                    e4.defend(leader);
                    System.out.println(leader.getName() + " just attacked " + e4.getName());
                    System.out.println(e4.getName() + "'s health:" + e4.getHealth());
                    e1.defend(leader);
                    System.out.println(leader.getName() + " just attacked " + e1.getName());
                    if (e1.isVisible()) {
                        System.out.println(e1.getName() + " was visible!");
                    } else {
                        System.out.println(e1.getName() + " was invisible!");
                    }
                    System.out.println(e1.getName() + "'s health:" + e1.getHealth());
                }
            } catch (Exception ex) {
                System.out.println("ffff");
                System.err.println(ex.toString());
            }
        }
        if (e4.wonBattle(e3)) {
            System.out.println(e4.getName() + " won the battle against " + e3.getName());
        } else {
            System.out.println(e4.getName() + " lost the battle against " + e3.getName());
        }
    }
}
