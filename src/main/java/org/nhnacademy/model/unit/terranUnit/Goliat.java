package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.Raser;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.type.unitType.Unit;

public class Goliat extends Unit implements NonFlyable, Raser, TerranUnit {
    public Goliat() {
        super(3, 15);
    }
}
