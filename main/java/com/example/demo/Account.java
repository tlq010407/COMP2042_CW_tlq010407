package com.example.demo;

import java.util.ArrayList;

/**
 * This class is used to contain all information of the account,
 * and contains several methods,
 * like add new account method,
 * match add the highest score to each account.
 */

public class Account implements Comparable<Account> {
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private long score = 0;
    private final String userName;

    public Account(String userName) {
        this.userName = userName;
    }
    public Account(String userName, int score) {
        this.userName = userName;
        this.score=score;
    }

    /**
     * Match the username with their exist account.
     * @param userName is username.
     * @return the account matched with the username.
     */
    static Account accountHaveBeenExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }

    /**
     * To make a new account if the account not exist.
     * @param userName is the name of the user.
     * @return add the new account into account arraylist.
     */
    static Account makeNewAccount(String userName) {
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

    /**
     * Compare the new score to the previous one according to the account,
     * and find the highest score to contain.
     * @param o the account which is used to compare the scores.
     * @return the highest score.
     */
    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /**
     * To add the score into new user account.
     * @param score is the new score from new user.
     */
    public void addToScore(long score) {
        this.score += score;
    }

    private long getScore() {
        return score;
    }

    private String getUserName() {
        return userName;
    }

}
