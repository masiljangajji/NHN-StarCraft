package org.nhnacademy.view;

public enum Path {

    PROTOS_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/protosUnit/"),
    ZERG_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/zergUnit/"),
    TERRAN_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/terranUnit/"),


    PROTOS_UNIT_CLASS_PATH("org.nhnacademy.model.unit.protosUnit."),
    ZERG_UNIT_CLASS_PATH("org.nhnacademy.model.unit.zergUnit."),
    TERRAN_UNIT_CLASS_PATH("org.nhnacademy.model.unit.terranUnit.");

    private final String path;


    Path(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.path;
    }
}
