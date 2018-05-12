/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Turner
 */
public class Board {
    public Board(){
          this._init();  
        }
        
        public Piece[][] board = new Piece[8][8];
        
        private void _init(){
            for(int x = 0; x < 8; x++){
                for(int y = 0; y < 8; y++){
                    char color = (x == 0) || (x == 1)? 'w' : 'b';
                    if (x == 2 || x == 3 || x == 4 || x == 5){
                        this.board[x][y] = new Piece();
                    } else if (x == 1 || x == 6){
                        this.board[x][y] = new Pawn(color, IdCounter.getId());
                    } else if (y == 0 || y == 7) {
                        this.board[x][y] = new Rook(color, IdCounter.getId());
                    } else if (y == 1 || y == 6) {
                        this.board[x][y] = new Knight(color, IdCounter.getId());
                    } else if (y == 2 || y == 5) {
                        this.board[x][y] = new Bishop(color, IdCounter.getId());
                    } else if (y == 3) {
                        this.board[x][y] = new Queen(color, IdCounter.getId());
                    } else if (y == 4) {
                        this.board[x][y] = new King(color, IdCounter.getId());
                    }
                }
            }
        }
        
        private Position getCurrentPosition(Piece piece){
            for(int x = 0; x < 8; x++){
                for(int y = 0; y < 8; y++){
                    if (this.board[x][y].getId() == piece.getId())
                        return new Position(x, y, true);
                }
            }
            return new Position(-1, -1, false);
        }
        
        private boolean isProposedPositionInbounds(Position currentPosition, int x, int y){
            return (currentPosition.getPositionX() + x <= 7) && (currentPosition.getPositionX() + x >= 0) && (currentPosition.getPositionY() + x <= 7) && (currentPosition.getPositionY() + x >= 0);
        }
        
        private Position getProposedPosition(Position currentPosition, Move move){
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
            if(isProposedPositionInbounds(currentPosition, x, y)){
                return new Position(x, y, true);
            } else {
                return new Position(-1, -1, false);
            }
            
        }
        
        private boolean _isSpaceOpen(Position proposedPositionPiece){
            return this.board[proposedPositionPiece.getPositionX()][proposedPositionPiece.getPositionY()].getId() < 1;
        }
        
        private boolean _isSpaceEnemy(Position proposedPositionPiece, Piece piece){
            return this.board[proposedPositionPiece.getPositionX()][proposedPositionPiece.getPositionY()].getColor() != piece.getColor();
        }
}
