package org.nhnacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.nhnacademy.model.Player;
import org.nhnacademy.model.unit.Unit;
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


    public static void playerAttack(Player player, Player computer) {


        Unit attackUnit = null;
        Unit defenseUnit = null;

        int playerUnitIndex = 0;
        int computerUnitIndex = 0;


        logger.info(Message.ATTACK_MESSAGE.toString());

        do {
            playerUnitIndex = selectPlayerUnit(player.getUnitListSize());
        } while (playerUnitIndex == -1);


        do {
            computerUnitIndex = selectComputerUnit(computer.getUnitListSize());
        } while (computerUnitIndex == -1);


        try {

            attackUnit = player.getUnitByListIndex(playerUnitIndex);
            defenseUnit = computer.getUnitByListIndex(computerUnitIndex);

            Attack.attack(attackUnit, defenseUnit);

        } catch (IllegalArgumentException e) {
            logger.warn("{}은(는) {}을(를) 공격할 수 없습니다", attackUnit.getClass().getSimpleName(),
                    defenseUnit.getClass().getSimpleName());
            logger.info("{}", Message.RETRY_INPUT);
            playerAttack(player, computer);
        }

        if (!defenseUnit.isAlive()) {
            computer.removeUnitByIndex(computerUnitIndex);
        }

    }

    public static void computerAttack(Player player, Player computer) {


        Unit attackUnit = null;
        Unit defenseUnit = null;


        int playerUnitIndex = (int) (Math.random() * player.getUnitListSize() + 1);
        int computerUnitIndex = (int) (Math.random() * computer.getUnitListSize() + 1);


        try {

            attackUnit = computer.getUnitByListIndex(computerUnitIndex);
            defenseUnit = player.getUnitByListIndex(playerUnitIndex);

            Attack.attack(attackUnit, defenseUnit);

        } catch (IllegalArgumentException e) {
            playerAttack(player, computer);
        }

        if (!defenseUnit.isAlive()) {
            player.removeUnitByIndex(computerUnitIndex);
        }

    }


//
//        playerUnitIndex = (int) (Math.random() * player.getUnitListSize() + 1);
//        computerUnitIndex = (int) (Math.random() * computer.getUnitListSize() + 1);
//
//        System.out.println(playerUnitIndex + " " + computerUnitIndex);
//
//        attackUnit = computer.getUnitByListIndex(computerUnitIndex - 1);
//        defenseUnit = player.getUnitByListIndex(playerUnitIndex - 1);
//
//        try {
//            player.takeDamageByListIndex(playerUnitIndex - 1, attackUnit.getDamage());
//            System.out.println("왜 다떄림 대체 왜");
//        } catch (IllegalArgumentException e) {
//            attack(player, computer, userAttack);
//        }
//
//        logger.info("{}이(가) {}을(를) 공격\n남은 체력 {}", attackUnit.getClass().getSimpleName(),
//                defenseUnit.getClass().getSimpleName(), defenseUnit.getDefense());
//
//        if (!defenseUnit.isAlive()) {
//            player.removeUnitByIndex(playerUnitIndex - 1);
//        }


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
            sc.nextLine();
            return -1;
        } catch (InputMismatchException e) {
            logger.warn("{}", Message.ONLY_NUMBER);
            logger.info("{}", Message.RETRY_INPUT);
            sc.nextLine();
            return -1;
        }
        return playerUnitIndex - 1;
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
            sc.nextLine();
            return -1;
        } catch (InputMismatchException e) {
            logger.warn("{}", Message.ONLY_NUMBER);
            logger.info("{}", Message.RETRY_INPUT);
            sc.nextLine();
            return -1;
        }
        return computerUnitIndex - 1;
    }

}
