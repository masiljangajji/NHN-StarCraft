package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.unit.Unit;

public class BattleCruzer extends Unit implements Flyable, TerranUnit {
    public BattleCruzer() {
        super(20, 30);
    }
}
