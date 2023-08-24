package board;

import MVC.GameView;
import pieces.*;
import status.PieceColor;


public class Board
{
    private static Board boardInstance;
    private GameView.DrawBox[][] drawBoxes = new GameView.DrawBox[8][8];

    private final Box[][] board = new Box[8][8];

    /* Populate the initial board */
    {
        // Black rooks
        this.board[0][0] = new Box(new Rook(PieceColor.BLACK));
        this.board[7][0] = new Box( new Rook(PieceColor.BLACK));

        // Black knights
        this.board[1][0] = new Box(new Knight(PieceColor.BLACK));
        this.board[6][0] = new Box(new Knight(PieceColor.BLACK));

        // Black bishops
        this.board[2][0] = new Box( new Bishop(PieceColor.BLACK));
        this.board[5][0] = new Box(new Bishop(PieceColor.BLACK));

        // Black queen
        this.board[3][0] = new Box(new Queen(PieceColor.BLACK));

        // Black king
        this.board[4][0] = new Box(new King(PieceColor.BLACK));

        // Populate black pawns
        for (int x = 0; x < 8; x++) {
            this.board[x][1] = new Box(new Pawn(PieceColor.BLACK));
        }

        // White rooks
        this.board[0][7] = new Box(new Rook(PieceColor.WHITE));
        this.board[7][7] = new Box(new Rook(PieceColor.WHITE));

        // White knights
        this.board[1][7] = new Box(new Knight(PieceColor.WHITE));
        this.board[6][7] = new Box(new Knight(PieceColor.WHITE));

        // White bishops
        this.board[2][7] = new Box(new Bishop(PieceColor.WHITE));
        this.board[5][7] = new Box(new Bishop(PieceColor.WHITE));

        // White queen
        this.board[3][7] = new Box(new Queen(PieceColor.WHITE));

        // White king
        this.board[4][7] = new Box(new King(PieceColor.WHITE));

        // Populate white pawns
        for (int x = 0; x < 8; x++) {
            this.board[x][6] = new Box(new Pawn(PieceColor.WHITE));
        }

        // Fill empty boxes
        for (int y = 2; y < 6; y++) {
            for (int x = 0; x < 8; x++) {
                this.board[x][y] = new Box(null);
            }
        }
    }


    /**
     * performs the swap operations of two Box objects
     * @param startX coordinate of the current piece
     * @param startY coordinate of the current piece
     * @param endX coordinate of the target piece
     * @param endY coordinate of the target piece
     */
    public void makeMove(int startX, int startY, int endX, int endY)
    {
        var temp = this.board[startX][startY];
        this.board[startX][startY] = this.board[endX][endY];
        this.board[endX][endY] = temp;
    }


    /**
     * to get board array
     * @return returns board array 8 x 8
     */
    public Box[][] getBoard()
    {
        return this.board;
    }

    /**
     * get draw boxes array
     * @return drawBoxes array
     */
    public GameView.DrawBox[][] getDrawBoxes()
    {
        return drawBoxes;
    }

    /**
     * get instance of the board class
     * @return Board object
     */
    public static Board getInstance()
    {
        if (boardInstance == null)
        {
            boardInstance = new Board();
        }
        return boardInstance;
    }



}
