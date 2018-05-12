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
     */
    public static int idCounter;
    
    public static void main(String[] args) {
        Game game = new Game();
        while (game.isContinuePlay()) {
            game.play();
        }
        System.out.println(game.getGameMessage());
    }
}
