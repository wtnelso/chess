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
public class King extends Piece {
    public King(char color, int id){
        this.id = id;
        this.color = color;
        this.firstMoveMax = 1;
        this.verticalMoveMax = 1;
        this.horizontalMoveMax = 1;
        this.diagonalMoveMax = 1;
    }
        
    @Override
    public boolean isBackwardAllowed() {
         return ! this.isBackward;
     }
}
