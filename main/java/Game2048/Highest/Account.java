package Game2048.Highest;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is used to contain all information of the account,
 * and contains several methods,
 * like add new account method,
 * match add the highest score to each account.
 */

public class Account implements Comparable<Account>, Serializable{
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private int score = 0;
    private static String userName;
    public Account(String userName) {
        this.userName = userName;
    }
    /**
     * Match the username with their exist account.
     *
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
     *
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
     *
     * @param o the account which is used to compare the scores.
     * @return the highest score.
     */
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /**
     * To add the score into new user account.
     *
     * @param score is the new score from new user.
     */
    public void addToScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
    public static String getUserName() {
        return userName;
    }

    public void combine(String name) {
        if (accountHaveBeenExist(name) == null){
            makeNewAccount(name);
            addToScore(0);
            try {
                FileOutputStream fos = new FileOutputStream("Rank.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Account account = new Account(name);
                oos.writeObject(account);
                oos.flush();
                oos.close();
                FileInputStream fis = new FileInputStream("Rank.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                account = (Account) ois.readObject();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            compareTo(accountHaveBeenExist(name));
        }
    }
}