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
public class Piece {
        public int id;
        public char color = ' ';
        public int xSpace;
        public int ySpace;
        public char pieceType = ' ';
        public boolean isPiece;
        public boolean isBackward;
        public boolean isDiagonal;
        public boolean isHorizontal;
        public boolean isLeft;
        public int firstMoveMax;
        public boolean isfirstMoveUsed;
        public int verticalMoveMax;
        public int horizontalMoveMax;
        public int diagonalMoveMax;
        public String[] acceptableMoveInputs;
        
        private final boolean _isAlive;
        
        public Piece(){
            this._isAlive = true;
        }
        
        public int getId(){
            return this.id;
        }
        
        public void setColor(char color) {
            this.color = color;
        }
        
        public char getColor(){
            return this.color;
        }
        
        public void setSpace(int xSpace, int ySpace){
            this.xSpace = xSpace;
            this.ySpace = ySpace;
        }
        
        public Integer[] getSpace(){
            return new Integer[] {this.xSpace, this.ySpace};
        }
        
        public boolean isBackwardAllowed() {
            return this.isBackward;
        }
        
        public int getVerticalMoveMax() {
            return this.verticalMoveMax;
        }
        
        public int getHorizontalMoveMax() {
            return this.horizontalMoveMax;
        }
        
        public int getDiagonalMoveMax() {
            return this.diagonalMoveMax;
        }
        
        public boolean isFirstMoveUsed(){
            if (! this._getFirstMoveUsed()) {
                this._setFirstMoveUsed();
            }
            return this._getFirstMoveUsed();
        }
        
        public int getFirstMoveMax(){
            return this.firstMoveMax;
        }
        
        private boolean _getFirstMoveUsed(){
            return this.isfirstMoveUsed;
        }
        
        private void _setFirstMoveUsed(){
            this.isfirstMoveUsed = true;
        }
        
        public boolean isMoveSizeValid(Move move) {
            return (! this.isFirstMoveUsed() && move.getTotalMoveSize() <= this.getFirstMoveMax()) || (move.getVerticalMove() <= this.getVerticalMoveMax()) || (move.getHorizontalMove()<= this.getHorizontalMoveMax()) || (move.getDiagonalMove()<= this.getDiagonalMoveMax());
        }
        
        public boolean isMoveDirectionValid(Move move){
            return (this.isBackwardAllowed() && move.isBackwardMove());
        }
        
        public boolean isMoveValid(Move move){
            return this.isMoveSizeValid(move) && this.isMoveDirectionValid(move);
        } 
        
        public boolean isAlive(){
            return this._isAlive;
        }
        
        public char getPieceType(){
            return this.pieceType;
        }
        
        public boolean isPiece(){
            return this.isPiece;
        }
        
        public String print(){
            return "     ";
        }
        
        public String printInputPrompt(){
            return "";
        }
        
        public String[] getAcceptableMoveInputs(){
            return this.acceptableMoveInputs;
        }
}
