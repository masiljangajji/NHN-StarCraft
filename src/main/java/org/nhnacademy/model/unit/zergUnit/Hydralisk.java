package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.Needle;
import org.nhnacademy.model.type.unitType.NonFlyable;
import org.nhnacademy.model.type.unitType.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;


public class Hydralisk extends Unit implements NonFlyable, Needle, ZergUnit {
    public Hydralisk() {
        super(3, 7);
    }
}
