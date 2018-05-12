/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.pieces;
import chess.Move;

/**
 *
 * @author Turner
 */
public class Knight extends Piece {
    public Knight(char color, int id){
        this.id = id;
        this.color = color;
        this.firstMoveMax = 4;
        this.verticalMoveMax = 3;
        this.horizontalMoveMax = 1;
        this.diagonalMoveMax = 0;
    }
        
    @Override
    public boolean isBackwardAllowed() {
         return ! this.isBackward;
     }

    @Override
    public boolean isMoveDirectionValid(Move move) {
         return (move.getHorizontalMove() == 1 && move.getVerticalMove() == 2) || (move.getHorizontalMove() == 2 && move.getVerticalMove() == 1);
     }
}
