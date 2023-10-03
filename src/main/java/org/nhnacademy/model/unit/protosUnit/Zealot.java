package org.nhnacademy.model.unit.protosUnit;

import org.nhnacademy.model.type.attackType.NonFlyableAttack;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.type.unitType.Unit;

public class Zealot extends Unit implements NonFlyable, NonFlyableAttack, ProtosUnit {
    public Zealot() {
        super(2, 2);
    }
}
