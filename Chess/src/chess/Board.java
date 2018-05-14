/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import chess.data_model.pieces.*;
import chess.data_model.utility.*;

/**
 *
 * @author Turner
 */
public class Board {
    public Piece[][] board = new Piece[8][8];
    
    public Board(){
        this._init();  
    }
          
    private void _init(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                char color = (x == 0) || (x == 1)? 'w' : 'b';
                if (x == 2 || x == 3 || x == 4 || x == 5){
                    this.board[x][y] = new Piece();
                } else if (x == 1 || x == 6){
                    this.board[x][y] = new Pawn(color, IdCounter.getId(), x, y);
                } else if (y == 0 || y == 7) {
                    this.board[x][y] = new Rook(color, IdCounter.getId(), x, y);
                } else if (y == 1 || y == 6) {
                    this.board[x][y] = new Knight(color, IdCounter.getId(), x, y);
                } else if (y == 2 || y == 5) {
                    this.board[x][y] = new Bishop(color, IdCounter.getId(), x, y);
                } else if (y == 3) {
                    this.board[x][y] = new Queen(color, IdCounter.getId(), x, y);
                } else if (y == 4) {
                    this.board[x][y] = new King(color, IdCounter.getId(), x, y);
                }
            }
        }
    }
        
    private Position _getCurrentPosition(Piece piece){
        return new Position(piece.getSpace()[0],piece.getSpace()[1], true);
    }
        
    private boolean _isProposedPositionInbounds(Position currentPosition, int x, int y){
        return (currentPosition.getPositionX() + x <= 7) && (currentPosition.getPositionX() + x >= 0) && (currentPosition.getPositionY() + x <= 7) && (currentPosition.getPositionY() + x >= 0);
    }
        
    private Position _getProposedPosition(Position currentPosition, Move move){
        int x; int y;
        if (move.isLeftMove()) {
            x = currentPosition.getPositionX() - move.getHorizontalMove();
        } else {
            x = currentPosition.getPositionX() + move.getHorizontalMove();
        }
        if (move.isBackwardMove()) {
           y = currentPosition.getPositionY() - move.getVerticalMove();
        } else {
           y = currentPosition.getPositionY() + move.getVerticalMove();
        } 
        if(_isProposedPositionInbounds(currentPosition, x, y)){
            return new Position(x, y, true);
        } else {
            return new Position(-1, -1, false);
        }
    }
        
    private boolean _isSpaceOpen(Position proposedPosition){
        return this.board[proposedPosition.getPositionX()][proposedPosition.getPositionY()].getId() < 1;
    }

    private boolean _isSpaceEnemy(Position proposedPosition, Piece piece){
        return this.board[proposedPosition.getPositionX()][proposedPosition.getPositionY()].getColor() != piece.getColor();
    }
    
    public BoardResponse makeMove(Piece piece, Move move){
        Position currentPosition = _getCurrentPosition(piece);
        Position proposedPosition = _getProposedPosition(currentPosition, move);
        if (proposedPosition.isAcceptablePosition()){
            if(this._isSpaceOpen(proposedPosition) || this._isSpaceEnemy(proposedPosition, piece)) {
                this._executeMove(piece, currentPosition, proposedPosition);
                return new BoardResponse(true, "Move Executed", this._isSpaceEnemy(proposedPosition, piece));
            } else {
                return new BoardResponse(false, "", this._isSpaceEnemy(proposedPosition, piece));
            }
        }
        return new BoardResponse(false, "", this._isSpaceEnemy(proposedPosition, piece));
    }
    
    private void _executeMove(Piece piece, Position currentPosition, Position proposedPosition){
        this.board[currentPosition.getPositionX()][currentPosition.getPositionY()] = new Piece();
        this.board[proposedPosition.getPositionX()][proposedPosition.getPositionY()] = piece;
    }
    
    public void draw(){
        PlayerFont.getHorizontalBorder();
        for (int x = 0; x < 8; x++){
           System.out.print("| ");
           for (int y = 0; y < 8; y++){
                System.out.print(PlayerFont.getPlayerFont(this.board[x][y]) + " | ");
            }
           PlayerFont.getHorizontalBorder();
        }
    }
}
