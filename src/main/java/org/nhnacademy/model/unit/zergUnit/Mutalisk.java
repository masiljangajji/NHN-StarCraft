package org.nhnacademy.model.unit.zergUnit;

import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.model.type.unitType.ZergUnit;


public class Mutalisk extends Unit implements Flyable, FlyableAttack, ZergUnit {
    public Mutalisk() {
        super(2, 8);
    }

    public Mutalisk setObject(){
        return new Mutalisk();
    }


}
