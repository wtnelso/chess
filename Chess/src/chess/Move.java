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
    
    public Move(){ 
        this._isBackwardMove = false;
        this._isVerticalMove = false;
        this._isHorizontalMove = false;
        this._isLeftMove = false;
        this._isDiagonalMove = false;
        this._verticalMove = 0;
        this._horizontalMove = 0;
        this._diagonalMove = 0;
    }
    
    private boolean _isBackwardMove;
    private boolean _isVerticalMove;
    private boolean _isHorizontalMove;
    private boolean _isLeftMove;
    private boolean _isDiagonalMove;
    private int _verticalMove;
    private int _horizontalMove;
    private int _diagonalMove;

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
    
    public void setIsBackwardMove(boolean isBackwardMove){
        this._isBackwardMove = isBackwardMove;
    }

    public void setIsVerticalMove(boolean isVerticalMove){
       this._isVerticalMove = isVerticalMove;
    }

    public void setIsHorizontalMove(boolean isHorizontalMove){
        this._isHorizontalMove = isHorizontalMove;
    }

    public void setIsLeftMove(boolean isLeftMove){
        this._isLeftMove = isLeftMove;
    }

    public void setIsDiagonallMove(boolean isDiagonalMove){
        this._isDiagonalMove = isDiagonalMove;
    }

    public void setVerticalMove(int verticalMove){
        this._verticalMove = verticalMove;
    }

    public void setHorizontalMove(int horizontalMove){
        this._horizontalMove = horizontalMove;
    }
    public void setDiagonalMove(int diagonalMove){
        this._diagonalMove = diagonalMove;
    }
}
