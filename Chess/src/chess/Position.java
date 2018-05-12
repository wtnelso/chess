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
public class Position {
    private final int _x;
        private final int _y;
        private final boolean _isAcceptablePosition;
        
        public Position(int x, int y, boolean isAcceptablePosition){
            this._x = x;
            this._y = y;
            this._isAcceptablePosition = isAcceptablePosition;
        }

        public int getPositionX(){
            return this._x;
        }
        
        public int getPositionY(){
            return this._y;
        }
        
        public boolean isAcceptablePosition(){
            return this._isAcceptablePosition;
        }
}
