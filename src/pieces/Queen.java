package pieces;

import board.Move;
import status.PieceColor;

public class Queen
    extends Piece
{

    public Queen(PieceColor color)
    {
        super(color);
        super.setImageInParent(this.isWhite() ? "png/wq.png" : "png/bq.png");
    }

    @Override
    public boolean isWhite() {
        return super.pieceColor == PieceColor.WHITE;
    }


    @Override
    public boolean canMove(Move move, int startX, int startY, int endX, int endY) {
        return false;
    }
}
