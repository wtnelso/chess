/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;

import chess.Board;
import chess.Player;

/**
 *
 * @author Turner
 */
public class GameController {
    private boolean _isStart;
    private Player _currentPlayer;
    private boolean _isPieceInput;
    private Board _board;
    
    public GameController(Player currentPlayer, Board board){
        this._isStart = true;
        this._currentPlayer = currentPlayer;
        this._board = board;
        currentPlayer.setIsPieceInput(true);
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
    
    public Player getCurrentPlayer(){
        return this._currentPlayer;
    }
    
    public Board getBoard(){
        return this._board;
    }
}
