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
public class Bishop extends Piece {
    public Bishop(char color, int id, int xSpace, int ySpace){
        this.color = color;
        this.id = id; 
        this.xSpace = xSpace;
        this.ySpace = ySpace;
        this.pieceType = 'B';
        this.firstMoveMax = 8;
        this.verticalMoveMax = 0;
        this.horizontalMoveMax = 0;
        this.diagonalMoveMax = 8;
    }
        
    @Override
    public boolean isBackwardAllowed() {
         return ! this.isBackward;
     }    
    
    @Override
    public boolean isPiece(){
        return ! this.isPiece;
    }
    
    @Override
    public String print(){
        return this.getPieceType()+ "(" + this.getId()+ ")";
    }
}
