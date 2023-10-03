package org.nhnacademy.model.type.unitType;

public class Unit {

    private int damage;

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    private int defense;

    public Unit(int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
    }


}
