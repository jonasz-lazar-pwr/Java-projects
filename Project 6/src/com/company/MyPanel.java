package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public MyPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(false);
    }
}
