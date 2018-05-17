/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import chess.data_model.utility.*;

/**
 *
 * @author nelson
 */
public class Chess {

    /**
     */
    public static int idCounter;
    
    public static void main(String[] args) {
        Game game = new Game();
        Board board = game.getBoard();
        Player playerWhite = game.getPlayerWhite();
        Player playerBlack = game.getPlayerBlack();
        UserInput userInput = new UserInput();
        GameController gameController = new GameController(playerWhite, board);
        Player currentPlayer = gameController.getCurrentPlayer();
        
        System.out.println(game.isContinuePlay());
        
        while (game.isContinuePlay()) {
            while (! gameController.isInputStatusFinal()){
                board.draw(currentPlayer.getColor());
                SystemOutput.SystemOutput(gameController);
                userInput.getInput(System.in, gameController);
            }
            if(userInput.getUserInputResponse().getUserInputResponseStatus()){
                BoardResponse boardResponse = board.makeMove(userInput.getPiece(), userInput.getMove());
                currentPlayer.updatePlayer(boardResponse);
            } else {
                
            }
            currentPlayer = AlternatePlayer.AlternatePlayer(playerWhite, playerBlack, gameController);
        }        
    }
}
