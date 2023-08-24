package pieces;

import board.Move;
import status.PieceColor;

import javax.imageio.ImageIO;
import java.io.File;

public class Bishop
    extends Piece
{
    public Bishop(PieceColor color)
    {
        super(color);
        super.setImageInParent(this.isWhite() ? "png/wb.png" : "png/bb.png");
    }

    @Override
    public boolean isWhite() {
        return super.pieceColor == PieceColor.WHITE;
    }

    @Override
    public boolean canMove(Move move, int startX, int startY, int endX, int endY)
    {
        return false;
    }
}




