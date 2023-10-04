package org.nhnacademy.model.unit.protosUnit;

import org.nhnacademy.model.type.attackType.Raser;
import org.nhnacademy.model.type.unitStatus.NonFlyable;
import org.nhnacademy.model.type.unitType.ProtosUnit;
import org.nhnacademy.model.unit.Unit;


public class Dragoon extends Unit implements NonFlyable, Raser, ProtosUnit {
    public Dragoon() {
        super(3, 15);
    }

    public Dragoon setObject(){
        return new Dragoon();
    }

}
