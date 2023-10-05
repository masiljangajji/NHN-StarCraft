package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.type.unitType.ZergUnit;
import org.nhnacademy.model.unit.Unit;

public class Queen extends Unit implements Flyable, FlyableAttack, ZergUnit {
    public Queen() {
        super(15, 25);
    }
}
