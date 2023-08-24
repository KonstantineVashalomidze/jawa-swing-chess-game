package MVC.eventListeners;

import MVC.Game;
import MVC.GameController;
import board.Board;
import board.Move;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MouseHandler
    extends MouseAdapter
{
    private Point drawBoxListenerCoordinate;
    private static List<Point> coordinatesShouldSwapPlaces =  new ArrayList<>();

    private Board board = Game.getGameBoard();


    private static List<MouseHandlerObserver> mouseHandlerObserverList = new ArrayList<>();

    public MouseHandler(int i, int counterForFillingDrawBoxes)
    {
        this.drawBoxListenerCoordinate = new Point(i, counterForFillingDrawBoxes);
    }

    @Override
    public void mouseClicked(MouseEvent event)
    {
        // Controls that user shouldn't move figure from empty box
        if (!(coordinatesShouldSwapPlaces.size() == 0 && this.board.getBoard()[drawBoxListenerCoordinate.x][drawBoxListenerCoordinate.y].getIsOccupiedBy() == null))
        {
            coordinatesShouldSwapPlaces.add(this.drawBoxListenerCoordinate);
        }

        if (coordinatesShouldSwapPlaces.size() == 2)
        {
            // make move
            this.board.makeMove(coordinatesShouldSwapPlaces.get(1).x, coordinatesShouldSwapPlaces.get(1).y
            , coordinatesShouldSwapPlaces.get(0).x, coordinatesShouldSwapPlaces.get(0).y);

            // clear list
            coordinatesShouldSwapPlaces = new ArrayList<>();

        }
        // notify observers to redraw the board
        notifyObservers();

    }



    public static void attachObserver(MouseHandlerObserver o)
    {
        mouseHandlerObserverList.add(o);
    }
    public static void detachObserver(MouseHandlerObserver o)
    {
        mouseHandlerObserverList.remove(o);
    }
    public static void notifyObservers()
    {
        mouseHandlerObserverList.forEach(MouseHandlerObserver::updateStateForMouseHandler);
    }


}
