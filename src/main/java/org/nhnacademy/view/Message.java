package org.nhnacademy.view;

public enum Message {


    PICK_TRIBE("종족을 선택해 주세요\n1 : Protos\n2 : Terran\n3 : Zerg"),


    RETRY_INPUT("다시 입력해 주세요"),

    ONLY_NUMBER("입력은 숫자만 가능합니다 !"),

    PLAYER_UNIT("Player 유닛"),
    OPPONENT_UNIT("Opponent 유닛"),

    PICK_ATTACK_AND_DEFENSE_UNIT("공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요"),

    SELECT_PLAYER_UNIT("공격할 아군 유닛을 선택해 주세요"),
    SELECT_ENEMY_UNIT("공격할 적군 유닛을 선택해 주세요"),
    PLAYER_LOSE("Player의 모든 Unit이 파괴 됐습니다!\nPlayer 패배"),
    COMPUTER_LOSE("Opponent의 모든 Unit이 파괴 됐습니다\nOpponent 패배"),
    END_GAME("게임을 종료합니다."),

    PLAYER_DESICION_LOSE("Player는 공중 공격 유닛이 없습니다.\nPlayer 패배"),
    OPPONENT_DESICION_LOSE("Opponent는 공중 공격 유닛이 없습니다\nOpponent 패배");

    private final String message;

    Message(String message) {
        this.message = message;
    }



}
