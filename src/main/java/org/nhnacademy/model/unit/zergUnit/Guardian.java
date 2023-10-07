package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;

public class Guardian extends Unit implements Flyable, ZergUnit {
    public Guardian() {
        super(3, 6);
    }


}
