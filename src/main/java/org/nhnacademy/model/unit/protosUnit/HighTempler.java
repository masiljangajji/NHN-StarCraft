package org.nhnacademy.model.unit.protosUnit;

import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitStatus.NonFlyable;

import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.unit.Unit;


public class HighTempler extends Unit implements NonFlyable, NonFlyableAttack, ProtosUnit {
    public HighTempler() {
        super(10, 2,false);
    }
}
