/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;
import chess.Chess;

/**
 *
 * @author Turner
 */
public class IdCounter {
    public static int getId(){
            return Chess.idCounter++ + 1;
        }
}
