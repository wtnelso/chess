/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;

import chess.Board;
import chess.Player;
import chess.data_model.pieces.Piece;

/**
 *
 * @author Turner
 */
public final class GameController {
    private boolean _isStart;
    private Player _currentPlayer;
    private boolean _isPieceInput;
    private boolean _isMoveDirectionInput;
    private boolean _isMoveSpaceInput;
    private final Board _board;
    private Piece _piece;
    private boolean _inputStatus;
    
    public GameController(Player currentPlayer, Board board){
        this._isStart = true;
        this._currentPlayer = currentPlayer;
        this._board = board;
        this.setIsPieceInput(true);
        this.setIsMoveDirectionInput(false);
        this.setIsMoveSpaceInput(false);
    }
    
    public boolean _isStart(){
        if (this._isStart) {
            this._isStart = ! this._isStart;
            return true;
        }
        return false;
    }
    
    public void setCurrentPlayer(Player currentPlayer){
        this._currentPlayer = currentPlayer;
    }
    
    public Player getCurrentPlayer(){
        return this._currentPlayer;
    }
    
    public Board getBoard(){
        return this._board;
    }
    
    public void setPiece(Piece piece){
        this._piece = piece;
    }
    
    public Piece getPiece(){
        return this._piece;
    }
    
    public void setIsPieceInput(boolean isPieceInput){
        this._isPieceInput = isPieceInput;
    }
    
    public boolean isPieceInput(){
        return this._isPieceInput;
    }
    
    public void setIsMoveDirectionInput(boolean isMoveDirectionInput){
        this._isMoveDirectionInput = isMoveDirectionInput;
    }
    
    public boolean isMoveDirectionInput(){
        return this._isMoveDirectionInput;
    }
    
    public void setIsMoveSpaceInput(boolean isMoveSpaceInput){
        this._isMoveSpaceInput = isMoveSpaceInput;
    }
    
    public boolean isMoveSpaceInput(){
        return this._isMoveSpaceInput;
    }
    
    public void setInputs(boolean isPieceInput, boolean isMoveDirectionInput, boolean isMoveSpaceInput, Piece piece){
        this.setIsPieceInput(isPieceInput);
        this.setIsMoveDirectionInput(isMoveDirectionInput);
        this.setIsMoveSpaceInput(isMoveSpaceInput);
        this.setPiece(piece);
    }
    
    public boolean isInputStatusFinal(){
        return this._inputStatus;
    }
    
    public void setIsInputStatusFinal(boolean inputStatus){
        this._inputStatus = inputStatus;
    }
}
