package pieces;

import board.Move;
import status.PieceColor;

public class Knight
    extends Piece
{

    public Knight(PieceColor color)
    {
        super(color);
        super.setImageInParent(this.isWhite() ? "png/wn.png" : "png/bn.png");
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
