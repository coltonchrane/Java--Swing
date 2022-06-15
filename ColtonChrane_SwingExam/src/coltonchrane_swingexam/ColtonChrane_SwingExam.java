
package coltonchrane_swingexam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ColtonChrane_SwingExam {


    public static void main(String[] args) {
        JFrame jframe = new JFrame("Colton Chrane");
        jframe.setBounds(50, 50, 480, 200);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);
        
        JLabel label1 = new JLabel("Secret Color: ");
        label1.setBounds(10, 10, label1.getPreferredSize().width + 175, label1.getPreferredSize().height + 50);
        jframe.add(label1);
        label1.setFont(new Font("Courier New", Font.BOLD, 30));
        label1.setForeground(Color.red);      
        label1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {
                label1.setForeground(Color.blue);
            }
            public void mouseReleased(MouseEvent e)
            {
                label1.setForeground(Color.red);
            }       
        });
        
        JButton b1 = new JButton("Quit");
        Dimension d = b1.getPreferredSize();
        b1.setBounds(jframe.getWidth()/2-50, 100, d.width, d.height);
        jframe.add(b1);
        b1.setVisible(false);
        b1.addActionListener((ActionEvent e) ->{
        System.exit(0);
        });
        JTextField color = new JTextField();
        color.setBounds(label1.getWidth() + 10, 25, 150, 35);
        color.setFont(new Font("Courier New", Font.BOLD, 30));
        jframe.add(color);
        color.addKeyListener(new KeyAdapter(){
        
             public void keyReleased(KeyEvent e)
             {
                 if(color.getText().equals("blue")||color.getText().equals("Blue"))
                 {
                     b1.setVisible(true);
                 }
                 else
                 {
                     b1.setVisible(false);
                 }
                 
             }
        });       
        
        
        jframe.setVisible(true);
    }
    
}
