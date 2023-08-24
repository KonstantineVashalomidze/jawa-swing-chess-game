package MVC;

import MVC.eventListeners.MouseHandler;
import account.Player;
import board.Board;
import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


public class GameView
    extends JFrame
{

    private Player sees;

    private Board board = Game.getGameBoard();

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    double MONITOR_HEIGHT = toolkit.getScreenSize().getHeight() - 100;
    double MONITOR_WIDTH = MONITOR_HEIGHT;


    public GameView()
    {

        // Draws grid
        this.drawGrid(7, Color.white, 0);
        // Draw initial board
        this.redrawBoard();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(40, 20, (int) MONITOR_WIDTH, (int) MONITOR_HEIGHT);
        this.setLayout(new GridLayout(8, 8));
        this.setTitle("OzuChess");
        this.setVisible(true);

    }


    public static class DrawBox
        extends JPanel
    {
        private Color color;

        public DrawBox()
        {
            this.setBorder(BorderFactory.createLineBorder(Color.black));
        }

        @Override
        public void paintComponent(Graphics g)
        {
            var g2 = (Graphics2D) g;

            // Draw the grid
            var rect = new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight());
            g2.setPaint(this.color);
            g2.fill(rect);
            g2.draw(rect);
        }

        public void setColor(Color color)
        {
            this.color = color;
        }

        public Color getColor()
        {
            return this.color;
        }

    }




    public boolean makeMove()
    {

        return false;
    }


    /**
     * call this when you change board.box object
     */
    public void redrawBoard()
    {

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (this.board.getBoard()[i][j].getIsOccupiedBy() != null)
                {
                    this.drawFigureOnBox(this.board.getBoard()[i][j], i, j);
                }
                else{
                    this.removeFigureFromBox(i, j);}
            }
        }
        this.repaint();
        this.revalidate();
    }


    /**
     * draws box on the frame with figure at certain coordinate
     * @param box class box
     */
    public void drawFigureOnBox(board.Box box, int x, int y)
    {
        var concreteDrawBox = this.board.getDrawBoxes()[x][y];

        this.board.getDrawBoxes()[x][y].add(new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                var g2 = (Graphics2D) g;
                if (box.getIsOccupiedBy() != null)
                    g2.drawImage(box.getIsOccupiedBy().getImage(), -5, -10, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(concreteDrawBox.getWidth(), concreteDrawBox.getHeight()); // Set preferred width and height
            }
        });
    }

    /**
     * removes figure from certain coordinate
     * @param x coordinate
     * @param y coordinate
     */
    public void removeFigureFromBox(int x, int y)
    {
        this.board.getDrawBoxes()[x][y].removeAll();
    }


    /**
     * Draws 8 x 8 grid
     */
    private void drawGrid(int counter, Color color, int counterForFillingDrawBoxes)
    {
        for (int i = 0; i < 8; i++)
        {
            // Fill the drawBoxes array for further use
            var drawBox = new GameView.DrawBox();
            drawBox.setColor(color);
            drawBox.addMouseListener(new MouseHandler(i, counterForFillingDrawBoxes));
            this.board.getDrawBoxes()[i][counterForFillingDrawBoxes] = drawBox;
            this.add(this.board.getDrawBoxes()[i][counterForFillingDrawBoxes]);
            // If color is white then change its color to gray otherwise white
            color = color.equals(Color.white) ? Color.gray : Color.white;
        }
        if (counter == 0) return;
        this.drawGrid(counter - 1, color.equals(Color.white) ? Color.gray : Color.white,
                counterForFillingDrawBoxes + 1);
    }




}




