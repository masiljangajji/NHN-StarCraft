package org.nhnacademy.model.unit.protosUnit;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.unit.Unit;


public class Scout extends Unit implements Flyable, FlyableAttack, ProtosUnit {
    public Scout() {
        super(5, 10);
    }



}
