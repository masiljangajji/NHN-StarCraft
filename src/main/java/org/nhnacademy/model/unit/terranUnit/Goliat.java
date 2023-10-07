package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.unit.Unit;

public class Goliat extends Unit implements NonFlyable, TerranUnit {
    public Goliat() {
        super(5, 15);
    }


}
