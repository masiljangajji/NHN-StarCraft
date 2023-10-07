package org.nhnacademy.model.unit.protosUnit;

import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.unit.Unit;


public class Dragoon extends Unit implements NonFlyable, ProtosUnit {
    public Dragoon() {
        super(3, 15);
    }


}
