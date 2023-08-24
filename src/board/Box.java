package board;

import pieces.*;

public class Box
{
    // If null then no piece is on it
    private Piece isOccupiedBy;

    public Box(Piece isOccupiedBy)
    {
        this.isOccupiedBy = isOccupiedBy;
    }


    public Piece getIsOccupiedBy() {
        return this.isOccupiedBy;
    }

    public void setIsOccupiedBy(Piece isOccupiedBy)
    {
        this.isOccupiedBy = isOccupiedBy;
    }
}
