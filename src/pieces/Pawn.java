package pieces;

import board.Move;
import status.PieceColor;

public class Pawn
    extends Piece
{

    public Pawn(PieceColor color)
    {
        super(color);
        super.setImageInParent(this.isWhite() ? "png/wp.png" : "png/bp.png");
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
