package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.unit.Unit;

public class Wraith extends Unit implements Flyable, FlyableAttack, TerranUnit {
    public Wraith() {
        super(3, 10, true);
    }


}
