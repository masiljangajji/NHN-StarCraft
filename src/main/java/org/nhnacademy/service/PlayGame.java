package org.nhnacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayGame {


    /**
     * 적군과 아군 유닛 표시
     * <p>
     * 공격을 실행할 유닛과 받을 유닛 선택
     * <p>
     * 컴퓨터는 무작위로 공격을 수행
     * <p>
     * 적군의 모든 유닛을 파괴하면 승리
     */


    private static final Logger logger = LoggerFactory.getLogger(PlayGame.class);

    private static final Scanner sc = new Scanner(System.in);


    public static int pickTribe() {
        logger.info("{}", Message.PICK_TRIBE);

        int num = 0;
        try {
            num = sc.nextInt();

            if (num < 1 || num > 3) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            logger.warn("{}", Message.INPUT_ERROR);
            logger.info("{}", Message.RETRY_INPUT);
            pickTribe();
        } catch (InputMismatchException e) {
            logger.warn("{}", Message.ONLY_NUMBER);
            logger.info("{}", Message.RETRY_INPUT);
            sc.nextLine();
            pickTribe();
        }


        return num;
    }


}
