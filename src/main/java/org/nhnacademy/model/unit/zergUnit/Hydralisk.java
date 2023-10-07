package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;


public class Hydralisk extends Unit implements NonFlyable, ZergUnit {
    public Hydralisk() {
        super(3, 7);
    }

}
