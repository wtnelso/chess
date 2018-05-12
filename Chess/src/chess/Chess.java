/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;


/**
 *
 * @author nelson
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Board board = new Board();
        
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                System.out.println(board.board[x][y].id);
            }
            System.out.println(' ');
        }*/

        Game game = new Game();
        while (game.isContinuePlay()) {
            game.play();
        }
        System.out.println(game.getGameMessage());
        
    }
    
    private static int idCounter;
    public static class IdCounter{
        public static int getId(){
            return idCounter++ + 1;
        }
    }
    
    
    
    public static class Game{
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
            return this._playResponse.status;
        }
        
        public String getGameMessage(){
            return this._playResponse.message;
        }
        
        public void play(){
            this._playResponse.status = false;
            this._playResponse.message = "End";
        }
        
    }
    
    public static class PlayResponse{
        public boolean status;
        public String message;
        
        public PlayResponse(){
            this.status = true;
            this.message = new String();
        }
    }
    
    public static class Player{
        public Player(char color){
            this._color = color;
            this._aliveCount = 16;
        }
        
        private final char _color;
        private int _aliveCount;
        
        public int getAliveCount(){
            return this._aliveCount;
        }
        
        public void decreaseAliveCount(){
            this._aliveCount--;
        }
        
    }
    
    public static class Board {
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
    
    public static class Position{
        private final int _x;
        private final int _y;
        private final boolean _isAcceptablePosition;
        
        public Position(int x, int y, boolean isAcceptablePosition){
            this._x = x;
            this._y = y;
            this._isAcceptablePosition = isAcceptablePosition;
        }

        public int getPositionX(){
            return this._x;
        }
        
        public int getPositionY(){
            return this._y;
        }
        
        public boolean isAcceptablePosition(){
            return this._isAcceptablePosition;
        }
    }
    public static class Piece {
        public int id;
        public char color = ' ';
        public boolean isBackward;
        public int firstMoveMax;
        public boolean isfirstMoveUsed;
        public int verticalMoveMax;
        public int horizontalMoveMax;
        public int diagonalMoveMax;
        private final boolean _isAlive;
        
        public Piece(){
            this._isAlive = true;
        }
        
        public int getId(){
            return this.id;
        }
        
        public void setColor(char color) {
            this.color = color;
        }
        
        public char getColor(){
            return this.color;
        }
        
        public boolean isBackwardAllowed() {
            return this.isBackward;
        }
        
        public int getVerticalMoveMax() {
            return this.verticalMoveMax;
        }
        
        public int getHorizontalMoveMax() {
            return this.horizontalMoveMax;
        }
        
        public int getDiagonalMoveMax() {
            return this.diagonalMoveMax;
        }
        
        public boolean isFirstMoveUsed(){
            if (! this._getFirstMoveUsed()) {
                this._setFirstMoveUsed();
            }
            return this._getFirstMoveUsed();
        }
        
        public int getFirstMoveMax(){
            return this.firstMoveMax;
        }
        
        private boolean _getFirstMoveUsed(){
            return this.isfirstMoveUsed;
        }
        
        private void _setFirstMoveUsed(){
            this.isfirstMoveUsed = true;
        }
        
        public boolean isMoveSizeValid(Move move) {
            return (! this.isFirstMoveUsed() && move.getTotalMoveSize() <= this.getFirstMoveMax()) || (move.getVerticalMove() <= this.getVerticalMoveMax()) || (move.getHorizontalMove()<= this.getHorizontalMoveMax()) || (move.getDiagonalMove()<= this.getDiagonalMoveMax());
        }
        
        public boolean isMoveDirectionValid(Move move){
            return (this.isBackwardAllowed() && move.isBackwardMove());
        }
        
        public boolean isMoveValid(Move move){
            return this.isMoveSizeValid(move) && this.isMoveDirectionValid(move);
        } 
        
        public boolean isAlive(){
            return this._isAlive;
        }
    }
    
    public static class Move {
        public Move(boolean isBackwardMove, boolean isVerticalMove, boolean isHorizontalMove, boolean isLeftMove, boolean isDiagonalMove, int verticalMove, int horizontalMove, int diagonalMove){
            this._isBackwardMove = isBackwardMove;
            this._isVerticalMove = isVerticalMove;
            this._isHorizontalMove = isHorizontalMove;
            this._isLeftMove = isLeftMove;
            this._isDiagonalMove = isDiagonalMove;
            this._verticalMove = verticalMove;
            this._horizontalMove = horizontalMove;
            this._diagonalMove = diagonalMove;
        }
        private final boolean _isBackwardMove;
        private final boolean _isVerticalMove;
        private final boolean _isHorizontalMove;
        private final boolean _isLeftMove;
        private final boolean _isDiagonalMove;
        private final int _verticalMove;
        private final int _horizontalMove;
        private final int _diagonalMove;
        
        public boolean isBackwardMove(){
            return this._isBackwardMove;
        }
        
        public boolean isVerticalMove(){
            return this._isVerticalMove;
        }
        
        public boolean isHorizontalMove(){
            return this._isHorizontalMove;
        }
        
        public boolean isLeftMove(){
            return this._isLeftMove;
        }
        
        public boolean isDiagonallMove(){
            return this._isDiagonalMove;
        }
        
        public int getVerticalMove(){
            return this._verticalMove;
        }
        
        public int getHorizontalMove(){
            return this._horizontalMove;
        }
        public int getDiagonalMove(){
            return this._diagonalMove;
        }
        
        public int getTotalMoveSize(){
            return this.getVerticalMove() + this.getHorizontalMove() + this.getDiagonalMove();
        }
    }
    
    public static class Pawn extends Piece {
        public Pawn(char color, int id){
            this.id = id;
            this.color = color;
            this.firstMoveMax = 2;
            this.verticalMoveMax = 1;
            this.horizontalMoveMax = 0;
            this.diagonalMoveMax = 1;
        }
    }
    
    public static class Rook extends Piece {
        public Rook(char color, int id){
            this.id = id;
            this.color = color;
            this.firstMoveMax = 8;
            this.verticalMoveMax = 8;
            this.horizontalMoveMax = 8;
            this.diagonalMoveMax = 0;
        }
        
       @Override
       public boolean isBackwardAllowed() {
            return ! this.isBackward;
        }
    }
    
    public static class Bishop extends Piece {
        public Bishop(char color, int id){
            this.id = id;
            this.color = color;
            this.firstMoveMax = 8;
            this.verticalMoveMax = 0;
            this.horizontalMoveMax = 0;
            this.diagonalMoveMax = 8;
        }
        
       @Override
       public boolean isBackwardAllowed() {
            return ! this.isBackward;
        }
    }
    
    public static class Knight extends Piece {
        public Knight(char color, int id){
            this.id = id;
            this.color = color;
            this.firstMoveMax = 4;
            this.verticalMoveMax = 3;
            this.horizontalMoveMax = 1;
            this.diagonalMoveMax = 0;
        }
        
       @Override
       public boolean isBackwardAllowed() {
            return ! this.isBackward;
        }
       
       @Override
       public boolean isMoveDirectionValid(Move move) {
            return (move.getHorizontalMove() == 1 && move.getVerticalMove() == 2) || (move.getHorizontalMove() == 2 && move.getVerticalMove() == 1);
        }
    }
    
    public static class Queen extends Piece {
        public Queen(char color, int id){
            this.id = id;
            this.color = color;
            this.firstMoveMax = 8;
            this.verticalMoveMax = 8;
            this.horizontalMoveMax = 8;
            this.diagonalMoveMax = 8;
        }
        
       @Override
       public boolean isBackwardAllowed() {
            return ! this.isBackward;
        }
    }
    
    public static class King extends Piece {
        public King(char color, int id){
            this.id = id;
            this.color = color;
            this.firstMoveMax = 1;
            this.verticalMoveMax = 1;
            this.horizontalMoveMax = 1;
            this.diagonalMoveMax = 1;
        }
        
       @Override
       public boolean isBackwardAllowed() {
            return ! this.isBackward;
        }
    }
}
