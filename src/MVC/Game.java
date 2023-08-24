package MVC;

import MVC.eventListeners.MouseHandlerObserver;
import board.Board;
import account.Player;
import board.Box;
import board.Move;
import status.GameStatus;

import java.awt.*;
import java.util.List;

public class Game
    implements MouseHandlerObserver
{
    private static Board gameBoard = Board.getInstance();
    private Player currentTurn;
    private GameStatus status;
    private Player[] isPlayedBy = new Player[2]; // white on index 0 and black on index 1

    public Game()
    {
        this.currentTurn = this.isPlayedBy[0];
    }


    /**
     * checks if the game is over
     * @return false if over true otherwise
     */

    public boolean isOver()
    {
        return false;
    }

    /**
     * checks if it is player's move
     * @return true if player's move false otherwise
     */
    public boolean playerMove()
    {
        return false;
    }

    /**
     * call this when move is made
     * @return successful move true otherwise false
     */
    public boolean makeMove()
    {
        // if current turn was white and move is made then now current turn is black.
        if (this.currentTurn == this.isPlayedBy[0])
        {
            this.currentTurn = this.isPlayedBy[1];
        }
        else {
            this.currentTurn = this.isPlayedBy[0];
        }
        return true;
    }

    public static Board getGameBoard()
    {
        return gameBoard;
    }

    @Override
    public void updateStateForMouseHandler()
    {

    }

}
