package org.nhnacademy.model.unit;

public abstract class Unit {



    private final String unitName;
    private final int damage;

    private int defense;


    public int getDefense() {
        return defense;
    }

    Unit(String unitName,int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
        this.unitName=unitName;
    }

    public void attack(Unit defenseUnit) {

        if (this instanceof NonFlyableAttackGround && defenseUnit instanceof Flyable) {
            throw new IllegalArgumentException();
        }

        defenseUnit.attackByEnemy(this.damage);
    }

    public void attackByEnemy(int attackDamage) {
        this.defense -= attackDamage;
    }

    public boolean isAlive() {
        if (this.defense <= 0) {
            return false;
        }
        return true;
    }

    public String getUnitName() {
        return unitName;
    }

    @Override
    public String toString() {
        return this.unitName + " 공격력 " + this.damage + " 현재 방어력: " + this.defense;
    }
}
