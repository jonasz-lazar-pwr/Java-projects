package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyToggleButton extends JToggleButton {

    public MyToggleButton() {
        this.setText("D/M");
        this.setFocusPainted(false);
        this.setContentAreaFilled(true);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        this.setForeground(Color.LIGHT_GRAY);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new LineBorder(new Color(58, 88, 159)));
    }
}
