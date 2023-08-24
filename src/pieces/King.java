package pieces;

import board.Move;
import status.PieceColor;

public class King
    extends Piece
{


    public King(PieceColor color)
    {
        super(color);
        super.setImageInParent(this.isWhite() ? "png/wk.png" : "png/bk.png");
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
