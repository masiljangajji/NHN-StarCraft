package org.nhnacademy.model.unit;

import org.nhnacademy.model.type.attackType.OnlyAttackGround;
import org.nhnacademy.model.type.unitStatus.Flyable;

public class Unit {

    private int damage;

    private int defense;

    public void attack(Unit defenseUnit, int damage) {

        if (this instanceof OnlyAttackGround && defenseUnit instanceof Flyable) {
            System.out.println("공중유닛을 때릴 수 없습니다.");
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

    protected Unit(int damage, int defense) {
        this.damage = damage;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " 공격력 " + this.damage + " 현재 방어력: " + this.defense;
    }
}
