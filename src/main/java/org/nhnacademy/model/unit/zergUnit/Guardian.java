package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitType.Flyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;

public class Guardian extends Unit implements Flyable, FlyableAttack, ZergUnit {
    public Guardian() {
        super(3,6);
    }
}
