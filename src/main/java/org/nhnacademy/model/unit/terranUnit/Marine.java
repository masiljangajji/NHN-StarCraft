package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.Unit;

public class Marine extends Unit implements NonFlyableAttack, NonFlyable, TerranUnit {

    public Marine() {
        super(3, 10);
    }




}
