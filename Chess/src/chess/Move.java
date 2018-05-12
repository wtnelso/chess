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
public class Move {
    public Move(boolean isBackwardMove, boolean isVerticalMove, boolean isHorizontalMove, boolean isLeftMove, boolean isDiagonalMove, int verticalMove, int horizontalMove, int diagonalMove){
            this._isBackwardMove = isBackwardMove;
            this._isVerticalMove = isVerticalMove;
            this._isHorizontalMove = isHorizontalMove;
            this._isLeftMove = isLeftMove;
            this._isDiagonalMove = isDiagonalMove;
            this._verticalMove = verticalMove;
            this._horizontalMove = horizontalMove;
            this._diagonalMove = diagonalMove;
        }
        private final boolean _isBackwardMove;
        private final boolean _isVerticalMove;
        private final boolean _isHorizontalMove;
        private final boolean _isLeftMove;
        private final boolean _isDiagonalMove;
        private final int _verticalMove;
        private final int _horizontalMove;
        private final int _diagonalMove;
        
        public boolean isBackwardMove(){
            return this._isBackwardMove;
        }
        
        public boolean isVerticalMove(){
            return this._isVerticalMove;
        }
        
        public boolean isHorizontalMove(){
            return this._isHorizontalMove;
        }
        
        public boolean isLeftMove(){
            return this._isLeftMove;
        }
        
        public boolean isDiagonallMove(){
            return this._isDiagonalMove;
        }
        
        public int getVerticalMove(){
            return this._verticalMove;
        }
        
        public int getHorizontalMove(){
            return this._horizontalMove;
        }
        public int getDiagonalMove(){
            return this._diagonalMove;
        }
        
        public int getTotalMoveSize(){
            return this.getVerticalMove() + this.getHorizontalMove() + this.getDiagonalMove();
        }
}
