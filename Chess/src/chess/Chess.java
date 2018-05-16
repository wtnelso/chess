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
        Player currentPlayer = new Player();
        UserInput userInput;
        GameController gameController = new GameController(playerWhite, board);
        
        
        board.draw();
        while (game.isContinuePlay()) {
            gameController = SystemOutput(gameController);
            userInput = new UserInput(System.in, gameController);
            
            //if (userInput.getInputResponseStatus()) {
            //    BoardResponse boardResponse = board.makeMove(userInput.getPiece(), userInput.getMove());
            //    currentPlayer.updatePlayer(boardResponse);
            //} else {
            //    
            //}
            currentPlayer = AlternatePlayer.AlternatePlayer(playerWhite, playerBlack, gameController);
        }
        
    }
    
    public static GameController SystemOutput(GameController gameController){
        if(gameController._isStart()){
            System.out.println("Welcome to Chess!");
        }
        System.out.println("Player " + gameController.getCurrentPlayer().geFulltColor() +"'s Turn");
        
        System.out.println("Which Piece would you like to move? Enter a piece ID:");
        gameController.getCurrentPlayer().setIsMoveInput(true);
        
        if(gameController.getCurrentPlayer().isMoveInput()){
            System.out.println("Enter the direction of the move:"); 
        }
        return gameController;
    }
}
