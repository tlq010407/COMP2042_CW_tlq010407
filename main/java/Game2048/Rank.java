package Game2048;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Rank extends Account{
    public Rank(String userName) {
        super(userName);
    }
    public void combine(String name, int score) {
        if (accountHaveBeenExist(name) == null){
            makeNewAccount(name);
            addToScore(score);
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


