package org.nhnacademy.model.type.unitType;

public class Unit {

    private Unit() {
    }

    private int damage;

    private int defense;


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

    public Unit(int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
    }

}
