package org.nhnacademy.view;

public enum Path {

    PROTOS_UNIT("src/main/resources/ProtosUnit.json"),
    ZERG_UNIT("src/main/resources/ZergUnit.json"),
    TERRAN_UNIT("src/main/resources/TerranUnit.json");
    private final String path;


    Path(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.path;
    }
}
