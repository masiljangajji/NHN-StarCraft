package org.nhnacademy.service;

import org.nhnacademy.model.unit.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Attack {

    private static final Logger logger = LoggerFactory.getLogger(Attack.class);


    public static void attack(Unit attackUnit, Unit defenseUnit) {

        if (attackUnit.isAttackFlyable()) {
            defenseUnit.takeDamage(attackUnit.getDamage());
        } else {

            if (defenseUnit.isFlyable()) {
                logger.warn("{}은(는) {}을(를) 공격할 수 없습니다", attackUnit.getClass().getSimpleName(),
                        defenseUnit.getClass().getSimpleName());
                throw new IllegalArgumentException();
            }
            defenseUnit.takeDamage(attackUnit.getDamage());
        }
    }


}
