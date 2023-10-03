package org.nhnacademy.view;

public enum Message {


    PICK_TRIBE("종족을 선택해 주세요\n1 : Terran\n2 : Zerg\n3 : Protos"),

    INPUT_ERROR("잘못된 입력입니다!"),

    RETRY_INPUT("다시 입력해 주세요"),

    PROTOS_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/protosUnit/"),
    ZERG_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/zergUnit/"),
    TERRAN_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/terranUnit/"),

    PROTOS_UNIT_CLASS_PATH("org.nhnacademy.model.unit.protosUnit."),
    ZERG_UNIT_CLASS_PATH("org.nhnacademy.model.unit.zergUnit."),
    TERRAN_UNIT_CLASS_PATH("org.nhnacademy.model.unit.terranUnit."),

    END_PROGRAMING("Error로 인해 프로그램이 종료됩니다."),

    ONLY_NUMBER("입력은 숫자만 가능합니다 !");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }


}
