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
public class Piece {
        public int id;
        public char color = ' ';
        public boolean isBackward;
        public int firstMoveMax;
        public boolean isfirstMoveUsed;
        public int verticalMoveMax;
        public int horizontalMoveMax;
        public int diagonalMoveMax;
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
}
