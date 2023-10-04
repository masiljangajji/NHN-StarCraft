package org.nhnacademy.model.unit;

public class Unit {

    private int damage;

    private int defense;

    public void takeDamage(int damage) {
        this.defense -= damage;
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

    protected Unit(int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " 공격력 " + this.getDamage() + " 현재 방어력: " + this.getDefense();
    }
}
