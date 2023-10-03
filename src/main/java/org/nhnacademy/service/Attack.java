package org.nhnacademy.service;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.unit.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Attack {

    private static final Logger logger = LoggerFactory.getLogger(Attack.class);


    public static void attack(FlyableAttack flyableAttackUnit, Unit defenseUnit) {
        attackUnit((Unit) flyableAttackUnit, defenseUnit);
    }

    public static void attack(NonFlyableAttack nonFlyableAttackUnit, NonFlyable nonFlyableUnit) {
        attackUnit((Unit) nonFlyableAttackUnit, (Unit) nonFlyableUnit);
    }

    public static void attack(NonFlyableAttack nonFlyableAttackUnit, Flyable flyableUnit) {
        logger.warn("{}은(는) {}을(를) 공격할 수 없습니다 !", nonFlyableAttackUnit.getClass().getSimpleName(),
                flyableUnit.getClass().getSimpleName());
        throw new IllegalArgumentException();
    }

    public static void attackUnit(Unit attackUnit, Unit defenseUnit) {
        defenseUnit.takeDamage(attackUnit.getDamage());
    }

}
