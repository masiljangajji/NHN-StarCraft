package org.nhnacademy.model.type.unitType;

public class Unit {

    private int damage;


    public void takeDamage(int damage) {
        this.defense = this.defense - damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isAlive() {
        if (this.defense <= 0) {
            return false;
        }
        return true;
    }


    private int defense;

    public Unit(int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
        //this.flyableAttack = flyableAttack;
    }


}
