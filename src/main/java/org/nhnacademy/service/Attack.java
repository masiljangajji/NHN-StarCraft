package org.nhnacademy.service;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Attack {

    private static final Logger logger = LoggerFactory.getLogger(Attack.class);

    public static void attackAllType(FlyableAttack attackUnit, Unit defenseUnit) {

    }

    public static void attackNonFlyableType(NonFlyableAttack attackUnit, NonFlyable defenseUnit) {

    }

    public static void attack(Unit attackUnit, Unit defenseUnit) {

        if (attackUnit instanceof FlyableAttack) {
            FlyableAttack flyableAttack = (FlyableAttack) attackUnit;
            attackAllType(flyableAttack, defenseUnit);
            return;
        }

        if (attackUnit instanceof NonFlyableAttack && defenseUnit instanceof NonFlyable) {
            NonFlyableAttack nonFlyableAttack = (NonFlyableAttack) attackUnit;
            NonFlyable nonFlyableUnit = (NonFlyable) defenseUnit;
            attackNonFlyableType(nonFlyableAttack, nonFlyableUnit);
            return;
        }

        logger.warn("해당 유닛은 날 수 있는 유닛을 공격할 수 없습니다 !");
        throw new IllegalArgumentException();

    }

}
