package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;


public class Ultralisk extends Unit implements NonFlyable, NonFlyableAttack, ZergUnit {
    public Ultralisk() {
        super(5, 15);
    }
}
