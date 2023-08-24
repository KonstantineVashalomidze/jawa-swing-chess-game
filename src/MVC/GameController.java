package MVC;

import MVC.eventListeners.MouseHandler;
import MVC.eventListeners.MouseHandlerObserver;
import board.Board;
import board.Move;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameController
    implements MouseHandlerObserver
{
    public Game manipulates;
    public GameView updates;


    public GameController(GameView updates, Game manipulates)
    {
        this.manipulates = manipulates;
        this.updates = updates;
        MouseHandler.attachObserver(this);
    }


    public boolean validateMove(Move move)
    {
        return false;
    }









    @Override
    public void updateStateForMouseHandler()
    {
        this.updates.redrawBoard();
    }

}
