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
public class King extends Piece {
    public King(char color, int id, int xSpace, int ySpace){
        this.color = color;
        this.id = id;
        this.xSpace = xSpace;
        this.ySpace = ySpace;
        this.pieceType = 'K';
        this.firstMoveMax = 1;
        this.verticalMoveMax = 1;
        this.horizontalMoveMax = 1;
        this.diagonalMoveMax = 1;
        this.acceptableMoveInputs = new String[] {"f", "b", "l", "r", "dfl", "dfr","dbl", "dbr"};
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
    
    @Override
    public String printInputPrompt(){
        return "Would you like to move forward(f),backward(b), left(l), right(r), diagonally forward left (dfl), diagonally forward left (dfr), diagonally backward left (dbl) or diagonally backward right (dbr)?";
    }
}
