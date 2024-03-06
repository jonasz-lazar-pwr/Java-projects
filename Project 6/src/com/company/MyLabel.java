package com.company;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel(String text) {
        this.setText(text);
        this.setPreferredSize(new Dimension(35, 35));
        this.setFont(new Font("Comic Sans", Font.BOLD, 18));
        this.setForeground(Color.LIGHT_GRAY);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setOpaque(false);
    }
}
