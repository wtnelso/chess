/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.pieces;

/**
 *
 * @author Turner
 */
public class Pawn extends Piece {
    public Pawn(char color, int id){
        this.id = id;
        this.color = color;
        this.firstMoveMax = 2;
        this.verticalMoveMax = 1;
        this.horizontalMoveMax = 0;
        this.diagonalMoveMax = 1;
    }
}
