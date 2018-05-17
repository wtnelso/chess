/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;

/**
 *
 * @author nelson
 */
public class SystemOutput {
    public static void SystemOutput(GameController gameController){
        if(gameController._isStart()){
            System.out.println("Welcome to Chess!");
        }
        
        if(gameController.isPieceInput()){
            System.out.println("Player " + gameController.getCurrentPlayer().getFullColor() + "'s Turn");
            System.out.println("Which Piece would you like to move? Enter a piece ID:");
        }
        
        if(gameController.isMoveDirectionInput()){
            System.out.println(gameController.getPiece().printInputPrompt()); 
        }
        
        if(gameController.isMoveSpaceInput()) {
            System.out.println("How many space would you like to move?");
        }
    }
}
