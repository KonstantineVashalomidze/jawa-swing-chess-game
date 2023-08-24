package pieces;

import board.Move;
import status.PieceColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Piece
{
    private boolean dead = false;
    protected PieceColor pieceColor;
    protected BufferedImage image;
    public Piece(PieceColor color)
    {
        this.pieceColor = color;
    }



    /**
     * get the image from folder and set it to image field
     */
    public void setImageInParent(String path)
    {
        try{
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract boolean isWhite();

    public boolean isDead(){
        return this.dead;
    }

    public abstract boolean canMove(Move move, int startX, int startY, int endX, int endY);


    public BufferedImage getImage()
    {
        return this.image;
    }


}
