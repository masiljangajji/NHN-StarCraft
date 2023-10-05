package org.nhnacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.nhnacademy.model.Player;
import org.nhnacademy.model.type.attackType.FlyableAttack;
import org.nhnacademy.model.type.unitStatus.Flyable;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayGame {

    private PlayGame() {
    }

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


    public static boolean playerAttack(Player player, Player computer) {


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
            return false;
        }


        logger.info("\nPlayer의 {}이(가) Computer의 {}을(를) 공격했습니다   남은 방어력{}", attackUnit.getClass().getSimpleName(),
                defenseUnit.getClass().getSimpleName(), defenseUnit.getDefense());


        if (!defenseUnit.isAlive()) {
            computer.removeUnitByIndex(computerUnitIndex);
        }

        return true;

    }

    public static boolean computerAttack(Player player, Player computer) {


        Unit attackUnit = null;
        Unit defenseUnit = null;


        int playerUnitIndex = (int) (Math.random() * player.getUnitListSize());
        int computerUnitIndex = (int) (Math.random() * computer.getUnitListSize());

        try {

            attackUnit = computer.getUnitByListIndex(computerUnitIndex);
            defenseUnit = player.getUnitByListIndex(playerUnitIndex);

            Attack.attack(attackUnit, defenseUnit);

        } catch (IllegalArgumentException e) {
            return false;
        }

        logger.info("\nComputer의 {}이(가) User의 {}을(를) 공격했습니다   남은 방어력{}", attackUnit.getClass().getSimpleName(),
                defenseUnit.getClass().getSimpleName(), defenseUnit.getDefense());

        if (!defenseUnit.isAlive()) {
            player.removeUnitByIndex(playerUnitIndex);
        }

        return true;
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

    public static boolean losdByDecisionCheck(Player player, Player opponent,String message) {

        boolean isFlyableAttackUnit = false;

        for (int i = 0; i < opponent.getUnitListSize(); i++) {
            Unit unit = opponent.getUnitByListIndex(i);

            if (unit instanceof Flyable) {
                isFlyableAttackUnit = true; // 컴퓨터는 나는 유닛 있음
                break;
            }
        }

        if (!isFlyableAttackUnit) // 나는 유닛 없으면 판정패 없음
        {
            return false;
        }

        for (int i = 0; i < player.getUnitListSize(); i++) {

            Unit unit = player.getUnitByListIndex(i);

            if (unit instanceof FlyableAttack) // 컴퓨터는 나는 유닛 있고 , 나는 공격할 유닛 있어
            {
                return false; // 판정패 아님
            }
        }

        logger.info("{}", message);

        return true; // 컴퓨터는 나는 유닛 있는데 , 나는 없음 판정패

    }


}
