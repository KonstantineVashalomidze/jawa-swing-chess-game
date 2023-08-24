package pieces;

import board.Board;
import board.Move;
import status.PieceColor;

public class Rook
    extends Piece
{



    public Rook(PieceColor color)
    {
        super(color);
        super.setImageInParent(this.isWhite() ? "png/wr.png" : "png/br.png");
    }


    @Override
    public boolean isWhite() {
        return super.pieceColor == PieceColor.WHITE;
    }



    @Override
    public boolean canMove(Move move, int startX, int startY, int endX, int endY)
    {
        var board = Board.getInstance();

        // Rook moves horizontally or vertically
        if (startX == endX)             // Moving vertically
            for (int i = Math.max(startY, endY) + 1; i < Math.max(startY, endY) - 1; i++)
            {
                if (board.getBoard()[startX][i].getIsOccupiedBy() != null)
                {
                    return false;
                }
            }
        else            // Moving horizontally
            for (int i = Math.max(startX, endX) + 1; i < Math.max(startX, endX) - 1; i++)
            {
                if (board.getBoard()[i][startY].getIsOccupiedBy() != null)
                {
                    return false;
                }
            }

        if (startX != endX || startY != endY) return false;

        // Check if the destination square is either unoccupied or occupied by an opponent's piece
        return board.getBoard()[endX][endY].getIsOccupiedBy() == null || move.targetIsOccupiedByOpponent();
    }






}
