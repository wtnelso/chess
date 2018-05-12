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
public class PlayResponse {
        private boolean _status;
        private String _message;
        
        public PlayResponse(){
            this._status = true;
            this._message = new String();
        }
        
        public void setPlayResponseStatus(boolean status){
            this._status = status;
        }
        
        public boolean getPlayResponseStatus(){
            return this._status;
        }
        
        public void setPlayResponseMessage(String message){
            this._message = message;
        }
        
        public String getPlayResponseMessage(){
            return this._message;
        } 
}
