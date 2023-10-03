package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;

public class Zergling extends Unit implements NonFlyable, NonFlyableAttack, ZergUnit {
    public Zergling() {
        super(2, 2);
    }
}