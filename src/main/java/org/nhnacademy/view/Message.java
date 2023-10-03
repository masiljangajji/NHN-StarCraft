package org.nhnacademy.view;

public enum Message {


    PICK_TRIBE("종족을 선택해 주세요\n1 : Terran\n2 : Zerg\n3 : Protos"),

    INPUT_ERROR("잘못된 입력입니다!"),

    RETRY_INPUT("다시 입력해 주세요");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.name();
    }




}
