package org.nhnacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.nhnacademy.model.Player;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayGame {

    private PlayGame() {
    }

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
            logger.warn("{}", Message.INPUT_RANGE_ERROR);
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

    public static void printUnitList(Player player, Player computer) {
        logger.info("\n{}", Message.PLAYER_UNIT);
        player.printUnitList();
        logger.info("{}", Message.COMPUTER_UNIT);
        computer.printUnitList();
    }

    public static void attackEnemy(Player player, Player computer) {

        int playerUnitIndex=selectPlayerUnit(player.getUnitListSize());
        int computerUnitIndex=selectComputerUnit(computer.getUnitListSize());

    }

    public static int selectPlayerUnit(int playerUnitMaxIndex) {
        int playerUnitIndex = 0;

        logger.info("{}", Message.SELECT_PLAYER_UNIT);
        try {
            playerUnitIndex = sc.nextInt();
            if (playerUnitIndex < 1 || playerUnitIndex > playerUnitMaxIndex) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            logger.warn("{}", Message.INPUT_RANGE_ERROR);
            logger.info("{}", Message.RETRY_INPUT);
            selectPlayerUnit(playerUnitMaxIndex);
        } catch (InputMismatchException e) {
            logger.warn("{}", Message.ONLY_NUMBER);
            logger.info("{}", Message.RETRY_INPUT);
            sc.nextLine();
            selectPlayerUnit(playerUnitMaxIndex);
        }
        return playerUnitIndex;
    }

    public static int selectComputerUnit(int computerUnitMaxIndex) {
        int computerUnitIndex = 0;

        logger.info("{}", Message.SELECT_ENEMY_UNIT);
        try {
            computerUnitIndex = sc.nextInt();
            if (computerUnitIndex < 1 || computerUnitIndex > computerUnitMaxIndex) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            logger.warn("{}", Message.INPUT_RANGE_ERROR);
            logger.info("{}", Message.RETRY_INPUT);
            selectComputerUnit(computerUnitMaxIndex);
        } catch (InputMismatchException e) {
            logger.warn("{}", Message.ONLY_NUMBER);
            logger.info("{}", Message.RETRY_INPUT);
            sc.nextLine();
            selectComputerUnit(computerUnitMaxIndex);
        }
        return computerUnitIndex;
    }

}
