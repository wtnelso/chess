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
        GameController gameController = new GameController();
        
        SystemOutput(gameController);
        board.draw();
        //while (game.isContinuePlay()) {
            //userInput = new UserInput(System.in);
            
            //if (userInput.getInputResponseStatus()) {
            //    BoardResponse boardResponse = board.makeMove(userInput.getPiece(), userInput.getMove());
            //    currentPlayer.updatePlayer(boardResponse);
            //} else {
            //    
            //}
            //currentPlayer = AlternatePlayer.AlternatePlayer(playerWhite, playerBlack);
        //}
        
    }
    
    public static void SystemOutput(GameController gameController){
        if(gameController._isStart()){
            System.out.println("Welcome to Chess!");
        }
    }
}
