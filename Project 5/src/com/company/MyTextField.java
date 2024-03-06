package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MyTextField extends JTextField implements FocusListener {

    private final String hint = "Wprowadź liczbę";

    public String getHint() {
        return hint;
    }

    public MyTextField() {
        this.setText(this.hint);
        this.setPreferredSize(new Dimension(200, 35));
        this.setFont(new Font("Comic Sans", Font.BOLD, 15));
        this.setForeground(Color.GRAY);
        this.setBackground(Color.LIGHT_GRAY);
        this.setCaretColor(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createLineBorder(new Color(249, 205, 7), 3));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(hint)) {
            setText("");
        } else {
            setText(getText());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().equals(hint) || getText().length()==0) {
            setText(hint);
        } else {
            setText(getText());
        }
    }
}
