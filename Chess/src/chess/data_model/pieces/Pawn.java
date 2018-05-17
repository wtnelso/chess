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
public class Pawn extends Piece  {
    public Pawn(char color, int id, int xSpace, int ySpace) {
        this.color = color;
        this.id = id;
        this.xSpace = xSpace;
        this.ySpace = ySpace;
        this.pieceType = 'P';
        this.firstMoveMax = 2;
        this.verticalMoveMax = 1;
        this.horizontalMoveMax = 0;
        this.diagonalMoveMax = 1;
        this.acceptableMoveInputs = new String[] {"f", "dfl", "dfr"};
    }
    
    @Override
    public boolean isPiece(){
        return ! this.isPiece;
    }
    
    @Override
    public String print(){
        return this.getPieceType()+ "(" + this.getId()+ ")";
    }
    
    public String printInputPrompt(){
        return "Would you like to move forward(f), diagonally forward left (dfl) or diagonally forward left (dfr)?";
    }
}
