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
public class Player {
    public Player(char color){
            this._color = color;
            this._aliveCount = 16;
        }
        
        private final char _color;
        private int _aliveCount;
        
        public int getAliveCount(){
            return this._aliveCount;
        }
        
        public void decreaseAliveCount(){
            this._aliveCount--;
        }
}
