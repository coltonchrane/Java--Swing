package coltonchrane_swinglab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ColtonChrane_SwingLab {

    public static void main(String[] args) {

        JFrame jframe = new JFrame("Log In");
        jframe.setBounds(50, 50, 350, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);

        JLabel label1 = new JLabel("Enter Username: ");
        label1.setBounds(10, 10, label1.getPreferredSize().width, label1.getPreferredSize().height);
        jframe.add(label1);

        JTextField un = new JTextField();
        un.setBounds(label1.getWidth() + 10, 10, 100, 18);
        jframe.add(un);

        JLabel label2 = new JLabel("Enter Password: ");
        label2.setBounds(10, 75, label1.getPreferredSize().width, label1.getPreferredSize().height);
        jframe.add(label2);

        JLabel error = new JLabel("Incorrect Format");
        error.setBounds(220, 75, label1.getPreferredSize().width, label1.getPreferredSize().height);
        jframe.add(error);

        JPasswordField pw = new JPasswordField();
        pw.setBounds(label1.getWidth() + 10, 75, 100, 18);
        jframe.add(pw);

        JButton b1 = new JButton("Save");
        Dimension d = b1.getPreferredSize();
        b1.setBounds(jframe.getWidth() - 100, 300, d.width, d.height);
        jframe.add(b1);
        b1.addActionListener((ActionEvent e) -> {
            //insert code here

            try {
                FileWriter fw = new FileWriter("login.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.append("username: " + un.getText() + "\r\n");
                bw.append("password: " + pw.getText() + "\r\n");
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }

        });
        JButton b2 = new JButton("Quit");
        Dimension d2 = b2.getPreferredSize();
        b2.setBounds((jframe.getWidth() / d.width) + 25, 300, d.width, d.height);
        jframe.add(b2);
        b2.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        b1.setBackground(Color.green);
        b2.setForeground(Color.RED);
        error.setForeground(Color.RED);
        pw.setEchoChar('$');
        b1.setVisible(false);
        error.setVisible(false);

        pw.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                int upperCount = 0, lowerCount = 0, digitCount = 0, symbolCount = 0;
                boolean pass = false;
                char[] input = pw.getPassword();
                for (char i : input) {
                    if (Character.isDigit(i)) {
                        digitCount++;
                    } else if (!Character.isDigit(i) && !Character.isAlphabetic(i) && !Character.isWhitespace(i)) {
                        symbolCount++;
                    }
                }

                //checks requirements
                if (digitCount < 1) {
                    pass = false;
                } else if (symbolCount < 1) {
                    pass = false;
                } else {
                    pass = true;
                }

                if (pw.getText().length() > 6 && un.getText().length() > 0 && pass == true) {
                    b1.setVisible(true);
                    error.setVisible(false);
                } else {
                    error.setVisible(
                            true);
                }

            }

        });

        jframe.setVisible(true);

    }

}
