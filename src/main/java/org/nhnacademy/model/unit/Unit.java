package org.nhnacademy.model.unit;

public class Unit {

    private Unit() {
    }

    private int damage;

    private int defense;

    private boolean attackFlyable;

    public boolean isFlyable() {
        return flyable;
    }

    private boolean flyable;

    public boolean isAttackFlyable() {
        return attackFlyable;
    }

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

    public Unit(int damage, int defense, boolean attackFlyable, boolean flyable) {
        this.damage = damage;
        this.defense = defense;
        this.attackFlyable = attackFlyable;
        this.flyable = flyable;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " 공격력 " + this.getDamage() + " 현재 방어력: " + this.getDefense();
    }
}
