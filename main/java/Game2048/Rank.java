package Game2048;

import Game2048.Account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Rank{
    public static void main(String[] args) {
        String username = Account.getUserName();
        int score = (int) Account.getScore();
        try {
            FileOutputStream fos = new FileOutputStream("Rank.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Account account = new Account(username,score);
            oos.writeObject(account);
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream("Rank.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            account = (Account) ois.readObject();
            System.out.println("Username: " + account.getUserName());
            System.out.println("Score: " + account.getScore());
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



