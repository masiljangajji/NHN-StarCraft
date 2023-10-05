package org.nhnacademy.service;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.unit.Unit;

public class Attack {


    public static void attack(Unit attackUnit, Unit defenseUnit) {

        if (attackUnit instanceof FlyableAttack) {
            defenseUnit.takeDamage(attackUnit.getDamage());
        } else {
            if (defenseUnit instanceof Flyable) {
                throw new IllegalArgumentException();
            }
            defenseUnit.takeDamage(attackUnit.getDamage());
        }
    }
}