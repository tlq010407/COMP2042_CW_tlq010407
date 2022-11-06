package Game2048;

import javafx.scene.Group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class Controller extends Component implements ActionListener {
    private final JFrame frame = null;

    public Group root;

    /**
     *
     */
    private void createMenu(){
        JMenuBar jmb = new JMenuBar();
        JMenu Game = new JMenu("Game");
        JMenuItem Game1 = new JMenuItem("New Game");
        JMenuItem Game2 = new JMenuItem("Exit");
        Game.add(Game1);
        Game.add(Game2);
        JMenu Help = new JMenu("Help");
        JMenuItem help = new JMenuItem("Rules");
        Help.add(help);
        JMenu ChangeBack = new JMenu("ChangeBackground");
        JMenuItem color1 = new JMenuItem("Pink");
        JMenuItem color2 = new JMenuItem("Green");
        JMenuItem color3 = new JMenuItem("Blue");
        ChangeBack.add(color1);
        ChangeBack.add(color2);
        ChangeBack.add(color3);
        jmb.add(Game);
        jmb.add(Help);
        jmb.add(ChangeBack);
        frame.setJMenuBar(jmb);

        Game1.addActionListener(this);
        Game2.addActionListener(this);
        help.addActionListener(this);
        color1.addActionListener(this);
        color2.addActionListener(this);
        color3.addActionListener(this);

        Game1.setActionCommand("restart");
        Game2.setActionCommand("exit");
        help.setActionCommand("rules");
        color1.setActionCommand("pink");
        color2.setActionCommand("green");
        color3.setActionCommand("blue");

    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("restarts".equals(command)){
            System.out.println("New Game");
            restart();
        }else if ("exit".equals(command)){
            System.out.println("Exit");
            Object[] options = {"OK" ,"cancel"};
            int res = JOptionPane.showOptionDialog(this,"Are You Sure?","Question", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,options,options[0]);
            if (res == 0){
                System.exit(0);
            }
        }else if ("rules".equals(command)){
            System.out.println("Rules");
            JOptionPane.showMessageDialog(null,"By clicking the up, down, left, right buttons in keyboard.","Rules:",JOptionPane.INFORMATION_MESSAGE);
        }else if ("pink".equals(command)){
            System.out.println("pink");
        }else if ("green".equals(command)){
            System.out.println("Green");
        }else{
            System.out.println("Blue");
        }

    }

    /**
     *
     */
    private void restart() {
    }
}
