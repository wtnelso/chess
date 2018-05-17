/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;
import chess.Player;

/**
 *
 * @author Turner
 */
public class AlternatePlayer {
    public static Player AlternatePlayer(Player playerWhite, Player playerBlack, GameController gameController){
        boolean isPlayerCurrent = playerWhite.isCurrentPlayer();
        playerWhite.setIsCurrentPlayer(! isPlayerCurrent);
        playerBlack.setIsCurrentPlayer(isPlayerCurrent);
        
        Player currentPlayer = playerWhite.isCurrentPlayer() ? playerWhite : playerBlack;
        gameController.setCurrentPlayer(currentPlayer);
        return currentPlayer;
    }
}
