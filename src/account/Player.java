package account;

import MVC.GameController;
import account.person.Person;
import board.Move;

public abstract class Player
    extends Account
{
    protected int totalGamesPlayed;
    protected boolean whiteSide;

    protected GameController uses;

    protected Person personality;

    protected boolean isWhiteSide()
    {
        return this.whiteSide;
    }

    public boolean isChecked()
    {
        return false;
    }

    public abstract boolean makeMove(Move move);


}
