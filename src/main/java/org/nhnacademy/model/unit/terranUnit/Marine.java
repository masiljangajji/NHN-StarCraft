package org.nhnacademy.model.unit.terranUnit;

import org.nhnacademy.model.type.attackType.OnlyAttackGround;
import org.nhnacademy.model.unit.Unit;

public class Marine extends Unit implements OnlyAttackGround {

    public Marine() {
        super(3, 10);
    }


}
