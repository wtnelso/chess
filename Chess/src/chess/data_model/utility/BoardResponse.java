/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;

/**
 *
 * @author Turner
 */
public class BoardResponse {
    private final boolean _status;
    private final String _message;
    private final boolean _isEnemyKilled;
    
    public BoardResponse(boolean status, String message, boolean isEnemyKilled){
        this._status = status;
        this._message = message;
        this._isEnemyKilled = isEnemyKilled;
    }
    
    public boolean isEnemyKilled(){
        return this._isEnemyKilled;
    }
}
