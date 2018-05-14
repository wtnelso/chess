/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.data_model.utility.BoardResponse;

/**
 *
 * @author Turner
 */
public class Player {
    private final char _color;
    private int _aliveCount;
    private boolean _isCurrentPlayer;
        
    public Player(char color){
        this._color = color;
        this._aliveCount = 16;
    }
    
    public Player() {
        this._color = ' ';
        this._aliveCount = 0;
    }

    public int getAliveCount(){
        return this._aliveCount;
    }

    private void _decreaseAliveCount(){
        this._aliveCount--;
    }
    
    public void setIsCurrentPlayer(boolean isCurrentPlayer){
        this._isCurrentPlayer = isCurrentPlayer;
    }
    
    public boolean isCurrentPlayer(){
        return this._isCurrentPlayer;
    }
    
    public char getColor(){
        return this._color;
    }
    
    public void updatePlayer(BoardResponse boardResponse){
        if (boardResponse.isEnemyKilled()){
            this._decreaseAliveCount();
        }
    }
}
