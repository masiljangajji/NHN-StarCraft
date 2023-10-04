package org.nhnacademy.view;

public enum Message {


    PICK_TRIBE("종족을 선택해 주세요\n1 : Terran\n2 : Zerg\n3 : Protos"),

    INPUT_RANGE_ERROR("입력 범위를 벗어났습니다!"),

    RETRY_INPUT("다시 입력해 주세요"),

    PROTOS_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/protosUnit/"),
    ZERG_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/zergUnit/"),
    TERRAN_UNIT_PATH("src/main/java/org/nhnacademy/model/unit/terranUnit/"),


    PROTOS_UNIT_CLASS_PATH("org.nhnacademy.model.unit.protosUnit."),
    ZERG_UNIT_CLASS_PATH("org.nhnacademy.model.unit.zergUnit."),
    TERRAN_UNIT_CLASS_PATH("org.nhnacademy.model.unit.terranUnit."),

    END_PROGRAMING("Error로 인해 프로그램이 종료됩니다."),

    ONLY_NUMBER("입력은 숫자만 가능합니다 !"),

    PLAYER_UNIT("Player 유닛"),
    COMPUTER_UNIT("Computer 유닛"),

    ATTACK_MESSAGE("공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요"),

    SELECT_PLAYER_UNIT("공격할 아군 유닛을 선택해 주세요"),
    SELECT_ENEMY_UNIT("공격할 적군 유닛을 선택해 주세요"),
    PLAYER_LOSE("Player의 모든 Unit이 파괴 됐습니다!\nPlayer 패배"),
    COMPUTER_LOSE("Computer의 모든 Unit이 파괴 됐습니다\nComputer 패배"),
    END_GAME("게임을 종료합니다."),

    PLAYER_DESICION_LOSE("플레이어가 공격 할 수 있는 유닛이 없습니다.\nPlayer 패배"),
    COMPUTER_DESICION_LOSE("컴퓨터가 공격 할 수 있는 유닛이 없습니다\nComputer 패배");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }


}
