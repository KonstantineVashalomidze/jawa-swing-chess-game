package board;

import pieces.Piece;
import account.Player;

public class Move
{
    private Box startBox;
    private Box endBox;
    private Piece pieceKilled;
    private boolean isCastling;

    public Move(Box startBox, Box endBox)
    {
        // Set default move not to be castling
        this.isCastling = false;
        this.startBox = startBox;
        this.endBox = endBox;



    }



    public void setCastling()
    {

    }


    public boolean targetIsOccupiedByOpponent()
    {
        return this.startBox.getIsOccupiedBy().isWhite() && !this.endBox.getIsOccupiedBy().isWhite()
                || !this.startBox.getIsOccupiedBy().isWhite() && this.endBox.getIsOccupiedBy().isWhite();
    }

    public Box getStartBox()
    {
        return startBox;
    }

    public void setStartBox(Box startBox) {
        this.startBox = startBox;
    }

    public Box getEndBox() { return endBox;  }

    public void setEndBox(Box endBox) {
        this.endBox = endBox;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }



    public boolean isCastling() {
        return isCastling;
    }

    public void setCastling(boolean castling) {
        isCastling = castling;
    }

    /**
     * checks if the user moved on the box where it is standing on now
     * @return true if yes false otherwise
     */
    public boolean movedOnSameBox()
    {
        return true;
    }

}
