package Game2048.Highest;

/**
 * This class is used to contain user's name of the account.
 */

public class Account{
    private static String userName;
    public Account(String userName) {
        Account.userName = userName;
    }
    public static String getUserName() {
        return userName;
    }

}
