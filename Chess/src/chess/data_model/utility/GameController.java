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
public class GameController {
    private boolean _isStart;
    
    public GameController(){
        this._isStart = true;
    }
    
    public boolean _isStart(){
        if (this._isStart) {
            this._isStart = ! this._isStart;
            return true;
        }
        return false;
    }
}
