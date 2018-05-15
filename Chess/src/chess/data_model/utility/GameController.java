/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;

import chess.Player;

/**
 *
 * @author Turner
 */
public class GameController {
    private boolean _isStart;
    private Player _currentPlayer;
    private boolean _isPieceInput;
    
    public GameController(Player currentPlayer){
        this._isStart = true;
        this._currentPlayer = currentPlayer;
    }
    
    public boolean _isStart(){
        if (this._isStart) {
            this._isStart = ! this._isStart;
            return true;
        }
        return false;
    }
    
    public void setPlayer(Player currentPlayer){
        this._currentPlayer = currentPlayer;
    }
    
    public Player getPlayer(){
        return this._currentPlayer;
    }
    
    public void setPieceInput(boolean isPieceInput){
        this._isPieceInput = isPieceInput;
    }
    
    public boolean isPieceInput(){
        return this._isPieceInput;
    }
}
