package org.nhnacademy.view;

public enum ErrorMessage {



    INPUT_RANGE("입력 범위를 벗어났습니다!"),
    END_PROGRAMING("Error로 인해 프로그램이 종료됩니다."),

    FILE_NOT_FOUND("해당 경로에 파일을 찾지 못했습니다."),

    IOEXEPTION("파일을 정상적으로 읽을수 없습니다."),

    PARSE("파일 Parsing이 올바르지 않습니다."),

    JSON_FILE_FORMAT("존재하지 않는 JSON Type입니다"),
    INPUT_NUMBER("입력은 정수형 숫자만 가능합니다 !");



    private final String error;

    ErrorMessage(String error) {
        this.error = error;
    }


    @Override
    public String toString() {
        return this.error;
    }
}
