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
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Turner
 */
public final class UserInput {
    private UserInputResponse _inputResponse = new UserInputResponse();
    private String _inputString;
    private Move _move = new Move();
    private Piece _piece = new Piece();
    
    public UserInput(){
        this._inputResponse = this.getUserInputResponse();
        this._inputString = this.getInputString();
        this._move = this.getMove();
        this._piece = this.getPiece();
    }
    
    public UserInput getInput(InputStream input, GameController gameController){
        this._inputString = new Scanner(input).nextLine().toLowerCase();
        if (! this._isInputValid(gameController).getUserInputResponseStatus()){
            System.out.println(this._isInputValid(gameController).getUserInputResponseMessage());
        }
        return new UserInput();
    }
    
    private UserInputResponse _isInputValid(GameController gameController) {
        if (this._inputString.length() < 1) {
            return new UserInputResponse(false, "No Input Was Provided");
        }
        if(gameController.isPieceInput()){
            if(Integer.parseInt(this._inputString) < 1){
                return new UserInputResponse(false, "Invalid Input Was Provided");
            }
            this.findPiece(this._inputString, gameController.getBoard());
            if (this.getPiece().getColor() == ' '){
                return new UserInputResponse(false, "Piece Not Selected");
            }
            if(gameController.getCurrentPlayer().getColor() != this.getPiece().getColor()){
                return new UserInputResponse(false, "Cannot Move Other Team's Piece");
            }
            gameController.setInputs(false, true, false, this.getPiece());
        }
        if(gameController.isMoveDirectionInput()){
            if(! this._isUserMoveInputValid()){
                return new UserInputResponse(false, "Cannot Move Piece In That Direction");
            } else {
                setMoveDirection(this._inputString);
                gameController.setInputs(false, false, true, this.getPiece());
                return new UserInputResponse(true, "");
            }            
        }
        if(gameController.isMoveSpaceInput()){
            
        }
        return new UserInputResponse(true, "");
        
    }
    
    public UserInputResponse getUserInputResponse(){
        return this._inputResponse;
    }
    
    public String getInputString(){
        return this._inputString;
    }
    
    public Move getMove(){
        return this._move;
    }
    
    public void setPiece(Piece piece){
        this._piece = piece;
    }
    
    public Piece getPiece(){
        return this._piece;
    }
    
    public boolean findPiece(String inputString, Board board){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if (board.board[x][y].getId() == Integer.parseInt(inputString)) {
                    setPiece(board.board[x][y]);
                    return true;
                }
            }
        }
        setPiece(new Piece());
        return true;
    }
    
    private boolean _isUserMoveInputValid(){
        return Arrays.asList(this._piece.getAcceptableMoveInputs()).contains(this._inputString);
    }
    
    private boolean _isUserSpaceInputValid(){
        Piece currentPiece = this.getPiece();
        Move currentMove = this.getMove();
        
        
        
        return true;
    }
    
    private void setMoveDirection(String inputString){
        this._move = new Move();
        switch(inputString.trim()){
            case "f":
                this.getMove().setIsVerticalMove(true);
                break;
            case "b":
                this.getMove().setIsVerticalMove(true);
                this.getMove().setIsBackwardMove(true);
                break;
            case "l":
                this.getMove().setIsHorizontalMove(true);
                this.getMove().setIsLeftMove(true);
                break;
            case "r":
                this.getMove().setIsHorizontalMove(true);
                break;
            case "dfl":
                this.getMove().setIsDiagonallMove(true);
                this.getMove().setIsLeftMove(true);
                break;
            case "dfr":
                this.getMove().setIsDiagonallMove(true);;
                break;
            case "dbl":
                this.getMove().setIsBackwardMove(true);
                this.getMove().setIsDiagonallMove(true);;
                this.getMove().setIsLeftMove(true);
                break;
            case "dbr":
                this.getMove().setIsBackwardMove(true);
                this.getMove().setIsDiagonallMove(true);
                break;
        }
    }
}
