package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;


public class Mutalisk extends Unit implements Flyable, FlyableAttack, ZergUnit {
    public Mutalisk() {
        super(2, 8);
    }
}
