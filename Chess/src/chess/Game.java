/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import chess.data_model.utility.PlayResponse;

/**
 *
 * @author Turner
 */
public class Game {
    private Player _playerWhite;
    private Player _playerBlack;
    private final Board _board;
    private final PlayResponse _playResponse;

    public Game(){
        this._playerWhite = new Player('w',"White");
        this._playerBlack = new Player('b',"Black");
        this._board = new Board();
        this._playResponse = new PlayResponse();
    }

    public boolean isContinuePlay(){
        return this._playResponse.getPlayResponseStatus();
    }

    public String getGameMessage(){
        return this._playResponse.getPlayResponseMessage();
    }

    public void setGameMessage(String message){
        this._playResponse.setPlayResponseMessage(message);
    }

    public boolean getGameStatus(){
        return this._playResponse.getPlayResponseStatus();
    }

    public void setGameStatus(boolean status){
        this._playResponse.setPlayResponseStatus(status);
    }

    public void play(){
        this._playResponse.setPlayResponseStatus(true);
        this._playResponse.setPlayResponseMessage("End");
    }
    
    public Board getBoard(){
        return this._board;
    }
    
    public Player getPlayerWhite(){
        this._playerWhite.setIsCurrentPlayer(true);
        return this._playerWhite;
    }
    
    public Player getPlayerBlack(){
        return this._playerBlack;
    }
}
