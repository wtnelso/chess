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
    private Board _board;
    private PlayResponse _playResponse;

    public Game(){
        this._playerWhite = new Player('w');
        this._playerWhite = new Player('b');
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
        this._playResponse.setPlayResponseStatus(false);
        this._playResponse.setPlayResponseMessage("End");
    }
}
