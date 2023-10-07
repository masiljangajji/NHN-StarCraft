package org.nhnacademy.model.unit.protosUnit;

import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.unit.Unit;

public class Carrier extends Unit implements Flyable {
    public Carrier() {
        super(25, 40);
    }
}
