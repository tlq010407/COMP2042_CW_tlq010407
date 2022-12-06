package com.example.game2048.Highest;


/**
 * This class is used to contain the information of users' name.
 * @author liqitang-modified
 */
public class Account{
    private static String userName;
    public static String getUserName() {
        return userName;
    }
    public static void setUserName(String userName) {
        Account.userName = userName;
    }
}