package org.nhnacademy.controller;


import org.nhnacademy.model.Player;
import org.nhnacademy.service.PlayGame;
import org.nhnacademy.view.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        int playerTribeNumber = 0;

        do {
            playerTribeNumber = PlayGame.pickTribe();
        } while (playerTribeNumber == -1);

        Player player = new Player(playerTribeNumber);

        Player computer = new Player((int) (Math.random() * 3 + 1));


        while (true) {

            PlayGame.printUnitList(player, computer);

            boolean playerAttackCheck;
            boolean computerAttackCheck;

            if (PlayGame.losdByDecision(player, computer, true)) {
                break;
            }

            do {
                playerAttackCheck = PlayGame.attackEnemy(player, computer,true);
            } while (!playerAttackCheck);

            if (computer.hasNoUnit()) {
                logger.info("{}", Message.COMPUTER_LOSE);
                break;
            }

            if (PlayGame.losdByDecision(computer, player, false)) {
                break;
            }


            do {
                computerAttackCheck = PlayGame.attackEnemy(computer, player,false);
            } while (!computerAttackCheck);


            if (player.hasNoUnit()) {
                logger.info("{}", Message.PLAYER_LOSE);
                break;
            }


        }

        logger.info("{}", Message.END_GAME);
    }


}
