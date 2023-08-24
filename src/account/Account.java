package account;

import status.AccountStatus;

public class Account
{
    private int id;
    private String password;
    private AccountStatus status;

    public boolean resetPassword()
    {
        return false;
    }

}
