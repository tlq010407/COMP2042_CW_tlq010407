package com.example.demo;

import java.util.ArrayList;

public class Account implements Comparable<Account> {
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private long score = 0;
    private final String userName;

    public Account(String userName) {
        this.userName = userName;
    }

    static Account accountHaveBeenExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;

    }

    static Account makeNewAccount(String userName) {
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

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
