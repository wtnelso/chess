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
    private String _fullColor;
    private int _aliveCount;
    private boolean _isCurrentPlayer;
    private boolean _isPieceInput;
    private boolean _isMoveInput;
    
    public Player(char color, String fullColor){
        this._color = color;
        this._fullColor = fullColor;
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
    
    public String geFulltColor(){
        return this._fullColor;
    }
    
    public void updatePlayer(BoardResponse boardResponse){
        if (boardResponse.isEnemyKilled()){
            this._decreaseAliveCount();
        }
    }
    
    public void setIsPieceInput(boolean isPieceInput){
        this._isPieceInput = isPieceInput;
    }
    
    public boolean isPieceInput(){
        return this._isPieceInput;
    }
    
    public void setIsMoveInput(boolean isMoveInput){
        this._isMoveInput = isMoveInput;
    }
    
    public boolean isMoveInput(){
        return this._isMoveInput;
    }
}
