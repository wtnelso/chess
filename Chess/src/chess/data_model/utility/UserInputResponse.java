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
public class UserInputResponse {
    private boolean _status;
    private String _message;
    
    public UserInputResponse(boolean status, String message) {
        this._status = status;
        this._message = message;
    }
    
    public UserInputResponse() {
    }
    
    public boolean getUserInputResponseStatus(){
        return this._status;
    }
    
    public String getUserInputResponseMessage(){
        return this._message;
    }
}
