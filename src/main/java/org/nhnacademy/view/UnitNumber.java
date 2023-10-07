package org.nhnacademy.view;

public enum UnitNumber {

    PROTOSS(4),

    TERRAN(5),
    ZERG(8);

    UnitNumber(int number) {
        this.number = number;
    }

    private final int number;

    public int getNumber() {
        return this.number;
    }


}
