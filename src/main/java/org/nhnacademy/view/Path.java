package org.nhnacademy.view;

public enum Path {

    PROTOS_UNIT_PATH("src/main/resources/ProtosUnit.json"),
    ZERG_UNIT_PATH("src/main/resources/ZergUnit.json"),
    TERRAN_UNIT_PATH("src/main/resources/TerranUnit.json");

    private final String path;


    Path(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.path;
    }
    }
