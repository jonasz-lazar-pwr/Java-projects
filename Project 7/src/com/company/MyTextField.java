package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyTextField extends JTextField {

    public MyTextField() {
        this.setPreferredSize(new Dimension(330, 70));
        this.setFont(new Font("Comic Sans", Font.PLAIN, 23));
        this.setForeground(Color.GRAY);
        this.setBackground(Color.LIGHT_GRAY);
        this.setCaretColor(Color.GRAY);
        this.setBorder(new LineBorder(new Color(58, 88, 159)));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setEditable(false);
    }
}
