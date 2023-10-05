package org.nhnacademy.controller;


import java.util.Scanner;
import org.nhnacademy.model.Player;
import org.nhnacademy.service.PlayGame;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        Player player = new Player(PlayGame.pickTribe());

        Player computer = new Player((int) (Math.random() * 3 + 1));

        if (!player.generateRandomUnit() || !computer.generateRandomUnit()) {
            return;
        }

        while (true) {

            PlayGame.printUnitList(player, computer);

            boolean playerAttackCheck;
            boolean computerAttackCheck;

            if (PlayGame.losdByDecisionCheck(player, computer, Message.PLAYER_DESICION_LOSE.toString())) {
                break;
            }

            do {
                playerAttackCheck = PlayGame.playerAttack(player, computer);
            } while (!playerAttackCheck);

            if (computer.hasNoUnit()) {
                logger.info("{}", Message.COMPUTER_LOSE);
                break;
            }

            if (PlayGame.losdByDecisionCheck(computer, player, Message.COMPUTER_DESICION_LOSE.toString())) {
                break;
            }


            do {
                computerAttackCheck = PlayGame.computerAttack(player, computer);
            } while (!computerAttackCheck);


            if (player.hasNoUnit()) {
                logger.info("{}", Message.PLAYER_LOSE);
                break;
            }


        }

        logger.info("{}", Message.END_GAME);
    }


}
