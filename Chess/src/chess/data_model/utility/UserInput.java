/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.data_model.utility;
import chess.Board;
import chess.Move;
import chess.data_model.pieces.Piece;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Turner
 */
public final class UserInput {
    private final UserInputResponse _inputResponse = new UserInputResponse();
    private final String _inputString;
    private final Move _move = new Move();
    private final Piece _piece = new Piece();
    
    public UserInput(InputStream input, GameController gameController){
        this._inputString = new Scanner(input).nextLine();
        if (this._isInputValid().getUserInputResponseStatus()){
            if(gameController.getCurrentPlayer().isPieceInput()){
                if(Integer.parseInt(this._inputString) < 1){
                    
                }
                if(gameController.getCurrentPlayer().getColor() != this.getPiece(this._inputString, gameController.getBoard()).getColor()){

                }
                gameController.getCurrentPlayer().setIsPieceInput(false);
                gameController.getCurrentPlayer().setIsMoveInput(true);
            }
        } else {
            System.out.println(this._isInputValid().getUserInputResponseMessage());
        }
    }
    
    private UserInputResponse _isInputValid() {
        if (this._inputString.length() < 1) {
            return new UserInputResponse(false, "No Input Was Provided");
        }
        return new UserInputResponse(true, "");
    }
    
    public boolean getInputResponseStatus(){
        return this._inputResponse.getUserInputResponseStatus();
    }
    
    public Move getMove(){
        return this._move;
    }
    
    public Piece getPiece(String inputString, Board board){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if (board.board[x][y].getId() == Integer.parseInt(inputString)) {
                    return board.board[x][y];
                }
            }
        }
        return new Piece();
    }
}
