import MVC.Game;
import MVC.GameController;
import MVC.GameView;

import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {


        EventQueue.invokeLater(() -> {
            var boardView = new GameView();
            var game = new Game();
            var gameController = new GameController(boardView, game);
            var gameController2 = new GameController(boardView, game);
        });


    }
}