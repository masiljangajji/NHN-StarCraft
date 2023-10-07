package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.OnlyAttackGround;
import org.nhnacademy.model.unit.Unit;

public class Tank extends Unit implements OnlyAttackGround {
    public Tank() {
        super(7, 15);
    }

}
