package com.company;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel(String text) {
        this.setText(text);
        this.setForeground(Color.GREEN);
        this.setBounds(270,42,200,15);
        this.setVisible(false);
    }
}
