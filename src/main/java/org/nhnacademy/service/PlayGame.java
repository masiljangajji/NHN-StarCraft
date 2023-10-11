package org.nhnacademy.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.nhnacademy.model.Player;
import org.nhnacademy.model.unit.Unit;
import org.nhnacademy.view.ErrorMessage;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayGame {

    private PlayGame() {
    }

    private static final Logger logger = LoggerFactory.getLogger(PlayGame.class);

    private static final Scanner sc = new Scanner(System.in);


    public static int pickTribe() {
        logger.info(Message.PICK_TRIBE.toString());

        int num = 0;
        try {
            num = sc.nextInt();

            if (num < 1 || num > 3) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            logger.warn(ErrorMessage.INPUT_RANGE.toString());
            logger.info(Message.RETRY_INPUT.toString());
            return -1;
        } catch (InputMismatchException e) {
            logger.warn(ErrorMessage.INPUT_NUMBER.toString());
            logger.info(Message.RETRY_INPUT.toString());
            sc.nextLine();
            return -1;
        }

        return num;
    }

    public static void printUnitList(Player player, Player opponent) {
        logger.info(Message.PLAYER_UNIT.toString());
        player.printUnitList();
        logger.info(Message.OPPONENT_UNIT.toString());
        opponent.printUnitList();
    }


    public static boolean attackEnemy(Player attackPlayer, Player defensePlayer, boolean check) {

        Unit attackUnit = null;
        Unit defenseUnit = null;

        int attackPlayerUnitIndex = 0;
        int defensePlayerUnitIndex = 0;


        if (check) {

            logger.info(Message.PICK_ATTACK_AND_DEFENSE_UNIT.toString());

            do {
                attackPlayerUnitIndex = selectUnit(attackPlayer.getUnitListSize(), true);
            } while (attackPlayerUnitIndex == -1);


            do {
                defensePlayerUnitIndex = selectUnit(defensePlayer.getUnitListSize(), false);
            } while (defensePlayerUnitIndex == -1);

            attackUnit = attackPlayer.getUnitByListIndex(attackPlayerUnitIndex);
            defenseUnit = defensePlayer.getUnitByListIndex(defensePlayerUnitIndex);

            try {
                attackUnit.attack(defenseUnit);
            } catch (IllegalArgumentException e) {
                logger.warn("{}은(는) {}을(를) 공격할 수 없습니다", attackUnit.getUnitName(),
                        defenseUnit.getUnitName());
                logger.info(Message.RETRY_INPUT.toString());
                return false;
            }

        } else {

            attackPlayerUnitIndex = (int) (Math.random() * attackPlayer.getUnitListSize());
            defensePlayerUnitIndex = (int) (Math.random() * defensePlayer.getUnitListSize());

            attackUnit = attackPlayer.getUnitByListIndex(attackPlayerUnitIndex);
            defenseUnit = defensePlayer.getUnitByListIndex(defensePlayerUnitIndex);

            try {
                attackUnit.attack(defenseUnit);
            } catch (IllegalArgumentException e) {
                return false;
            }

        }

        logger.info("\n{}이(가)  {}을(를) 공격했습니다   남은 방어력{}", attackUnit.getUnitName(),
                defenseUnit.getUnitName(), defenseUnit.getDefense());

        if (!defenseUnit.isAlive()) {
            defensePlayer.removeUnitByIndex(defensePlayerUnitIndex);
        }

        return true;
    }


    public static int selectUnit(int unitMaxIndex, boolean pickMyUnit) {
        int playerUnitIndex = 0;

        if (pickMyUnit) {
            logger.info(Message.SELECT_PLAYER_UNIT.toString());
        } else {
            logger.info(Message.SELECT_ENEMY_UNIT.toString());
        }
        try {
            playerUnitIndex = sc.nextInt();
            if (playerUnitIndex < 1 || playerUnitIndex > unitMaxIndex) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            logger.warn(ErrorMessage.INPUT_RANGE.toString());
            logger.info(Message.RETRY_INPUT.toString());
            sc.nextLine();
            return -1;
        } catch (InputMismatchException e) {
            logger.warn(ErrorMessage.INPUT_NUMBER.toString());
            logger.info(Message.RETRY_INPUT.toString());
            sc.nextLine();
            return -1;
        }


        return playerUnitIndex - 1;
    }

    public static boolean losdByDecision(Player player, Player opponent, boolean check) {


        boolean isPlayerFlyableAttack = player.canAttackFlyableUnit();
        boolean isOpponentFlyableUnit = opponent.isFlyableUnit();


        if (!isPlayerFlyableAttack && isOpponentFlyableUnit) { // player 공중공격 못하는데 , opponent는 공중유닛 있어

            if (check) {
                logger.info(Message.PLAYER_DESICION_LOSE.toString());
            } else {
                logger.info(Message.OPPONENT_DESICION_LOSE.toString());
            }

            return true;
        }

        return false;

    }


}
