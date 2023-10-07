package org.nhnacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.nhnacademy.model.Player;
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
            return -1;
        } catch (InputMismatchException e) {
            logger.warn("{}", Message.ONLY_NUMBER);
            logger.info("{}", Message.RETRY_INPUT);
            sc.nextLine();
            return -1;
        }

        return num;
    }

    public static void printUnitList(Player player, Player computer) {
        logger.info("\n{}", Message.PLAYER_UNIT);
        player.printUnitList();
        logger.info("{}", Message.COMPUTER_UNIT);
        computer.printUnitList();
    }


    public static boolean attackEnemy(Player attackPlayer, Player defensePlayer) {


        Unit attackUnit = null;
        Unit defenseUnit = null;

        int attackPlayerUnitIndex = 0;
        int defensePlayerUnitIndex = 0;


        logger.info(Message.ATTACK_MESSAGE.toString());

        do {
            attackPlayerUnitIndex = selectPlayerUnit(attackPlayer.getUnitListSize());
        } while (attackPlayerUnitIndex == -1);


        do {
            defensePlayerUnitIndex = selectComputerUnit(defensePlayer.getUnitListSize());
        } while (defensePlayerUnitIndex == -1);


        try {

            attackUnit = attackPlayer.getUnitByListIndex(attackPlayerUnitIndex);
            defenseUnit = defensePlayer.getUnitByListIndex(defensePlayerUnitIndex);

            attackUnit.attack(defenseUnit);

        } catch (IllegalArgumentException e) {
            logger.warn("{}은(는) {}을(를) 공격할 수 없습니다", attackUnit.getClass().getSimpleName(),
                    defenseUnit.getClass().getSimpleName());
            logger.info("{}", Message.RETRY_INPUT);
            return false;
        }

        logger.info("\n{}이(가)  {}을(를) 공격했습니다   남은 방어력{}", attackUnit.getClass().getSimpleName(),
                defenseUnit.getClass().getSimpleName(), defenseUnit.getDefense());


        if (!defenseUnit.isAlive()) {
            defensePlayer.removeUnitByIndex(defensePlayerUnitIndex);
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

    public static boolean losdByDecision(Player player, Player opponent,int check) {


        boolean isPlayerFlyableAttack = player.canAttackFlyableUnit();
        boolean isOpponentFlyableUnit = opponent.isFlyableUnit();


        if(!isPlayerFlyableAttack&&isOpponentFlyableUnit){

            if(check==1)
                logger.info("{}", Message.PLAYER_DESICION_LOSE);
            else
                logger.info("{}",Message.COMPUTER_DESICION_LOSE);

            return true;
        }

        return false;

    }




}
