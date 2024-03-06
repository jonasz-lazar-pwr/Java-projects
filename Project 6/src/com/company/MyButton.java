package com.company;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String text) {
        this.setFocusPainted(false);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setFont(new Font("Comic Sans", Font.BOLD, 18));
        this.setForeground(Color.DARK_GRAY);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createLineBorder(new Color(249, 205, 7),3));
        this.setPreferredSize(new Dimension(100, 35));
        this.setText(text);
    }
}
