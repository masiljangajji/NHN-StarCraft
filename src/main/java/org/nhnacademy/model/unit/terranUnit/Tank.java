package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.Unit;

public class Tank extends Unit implements NonFlyable, NonFlyableAttack, TerranUnit {
    public Tank() {
        super(7, 15);
    }
}