/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Turner
 */
public class Queen extends Piece {
    public Queen(char color, int id){
        this.id = id;
        this.color = color;
        this.firstMoveMax = 8;
        this.verticalMoveMax = 8;
        this.horizontalMoveMax = 8;
        this.diagonalMoveMax = 8;
    }
        
    @Override
    public boolean isBackwardAllowed() {
         return ! this.isBackward;
     }
}
