
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fatih
 */
public class Oyun_Bitti extends JPanel{
 JLabel label;
    Font font;
    public Oyun_Bitti() {
        font=new Font("Algerian", Font.BOLD,    50);
        label=new JLabel("GAME OVER");
        label.setFont(font);
        setBounds(0,0,600,600);
        setLayout(null);
        label.setBounds(125,250,500,100);
        add(label);
        setBackground(Color.red);
    }
    
}
