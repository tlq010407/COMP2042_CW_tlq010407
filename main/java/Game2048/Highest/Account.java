package Game2048.Highest;

/**
 * This class is used to contain the information of users' name,
 */
public class Account{
    private static String userName;
    public Account(String userName) {
        this.userName = userName;
    }
    public static String getUserName() {
        return userName;
    }
}