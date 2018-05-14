/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;
import chess.data_model.pieces.Piece;

/**
 *
 * @author Turner
 */
public class PlayerFont {
    public static String getPlayerFont(Piece piece){
        if (piece.getColor() == 'w') {
            return "\033[1m" + piece.print() +"\033[0m";
        }
        return piece.print();
    }
    
    public static void getHorizontalBorder(){
        System.out.println("");
        System.out.println("_________________________________________________________________");
    }
}
