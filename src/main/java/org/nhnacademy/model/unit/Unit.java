package org.nhnacademy.model.unit;

public abstract class Unit {

    String unitName;
    private int damage;

    public int getDefense() {
        return defense;
    }

    private int defense;

//    public void attack(Unit defenseUnit) {
//
//        if (this instanceof OnlyAttackGround && defenseUnit instanceof Flyable) {
//            throw new IllegalArgumentException();
//        }
//
//        defenseUnit.attackByEnemy(this.damage);
//    }

    public void attackByEnemy(int attackDamage) {
        this.defense -= attackDamage;
    }

    public boolean isAlive() {
        if (this.defense <= 0) {
            return false;
        }
        return true;
    }

    protected Unit(String unitName,int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
        this.unitName=unitName;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " 공격력 " + this.damage + " 현재 방어력: " + this.defense;
    }
}
