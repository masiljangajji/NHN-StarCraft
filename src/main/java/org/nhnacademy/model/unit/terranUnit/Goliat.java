package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.Missile;
import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.type.unitType.TerranUnit;
import org.nhnacademy.model.unit.Unit;

public class Goliat extends Unit implements NonFlyable, Missile, TerranUnit {
    public Goliat() {
        super(5, 15);
    }

    public Goliat setObject(){
        return new Goliat();
    }

}
