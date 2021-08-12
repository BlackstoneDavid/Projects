package com.ui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame
{
    public MyFrame()
    {
        this.setTitle("Game Pricer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);

        this.setIconImage(new ImageIcon("gamepad.png").getImage());
        this.getContentPane().setBackground(Color.white);
        ImageIcon carImage = new ImageIcon("tmcar.png");

        JLabel label = new JLabel();
        label.setText("Beep boop");
        label.setIcon(carImage);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        this.add(label);
    }
}
