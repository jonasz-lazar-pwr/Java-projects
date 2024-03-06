package com.company;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainFrame extends JFrame implements ActionListener, DocumentListener {

    ArrayList<MyCheckBox> checkBoxes = new ArrayList<>();
    ArrayList<MyTextField> textFields = new ArrayList<>();

    private JPanel firstPanel;
    private BarChart barChart;

    public MainFrame() throws HeadlessException {

        initComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(700, 520);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.requestFocusInWindow();

        this.add(firstPanel);
        this.add(barChart);
    }

    private void initComponents() {

        firstPanel = new JPanel();
        firstPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 10));
        firstPanel.setBounds(10, 10, 240, 460);
        firstPanel.setOpaque(false);

        for (int i = 0; i < 10; i++) {
            checkBoxes.add(new MyCheckBox());
            checkBoxes.get(i).addActionListener(this);

            textFields.add(new MyTextField());
            textFields.get(i).getDocument().addDocumentListener(this);
        }

        for (int i = 0; i < 10; i++) {
            firstPanel.add(checkBoxes.get(i));
            firstPanel.add(textFields.get(i));
        }

        Integer[] numbers = new Integer[10];
        Arrays.fill(numbers, null);

        Integer[] colors = new Integer[10];
        Arrays.fill(colors, null);

        barChart = new BarChart(numbers, colors);
    }

    private void textFieldUpdate() {

        try {
            int index = 0;
            for (MyTextField textField : textFields) {
                String textFromField = textField.getText();
                if (checkBoxes.get(index).isSelected() && textField.hasFocus()) {
                    if (textFromField.matches("^[1-9][\\d]*$") || textFromField.matches("^0$")) {
                        textField.setForeground(Color.GRAY);
                        barChart.tabOfNumbersUpdate(index, Integer.parseInt(textFromField));
                        repaint();
                    } else if (textFromField.equals("")) {
                        barChart.tabOfNumbersUpdate(index, null);
                        repaint();
                    } else {
                        textField.setForeground(Color.RED);
                        barChart.tabOfNumbersUpdate(index, null);
                        repaint();
                        throw new IllegalArgumentException("Wprowadzona wartość jest nieprawidłowa!");
                    }
                } else if (checkBoxes.get(index).isSelected() && !textField.hasFocus()) {
                    if (Objects.equals(textFromField, textField.getHint())) {
                        barChart.tabOfNumbersUpdate(index, null);
                        repaint();
                    }
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkBoxUpdate(ActionEvent event) {

        try {
            int index = 0;
            for (MyCheckBox checkBox : checkBoxes) {
                String textFromField = textFields.get(index).getText();
                if (checkBox == event.getSource()) {
                    if (checkBox.isSelected()) {
                        if (textFromField.matches("^[1-9][\\d]*$") || textFromField.matches("^0$")) {
                            barChart.tabOfNumbersUpdate(index, Integer.parseInt(textFromField));
                            repaint();
                        } else {
                            checkBox.setSelected(false);
                            barChart.tabOfNumbersUpdate(index, null);
                            repaint();
                            throw new IllegalArgumentException("Wprowadzona wartość jest nieprawidłowa!");
                        }
                    } else if (!checkBox.isSelected()) {
                        barChart.tabOfNumbersUpdate(index, null);
                        repaint();
                    }
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(barChart, "Wprowadzona wartość jest nieprawidłowa!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkBoxUpdate(e);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        textFieldUpdate();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        textFieldUpdate();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        textFieldUpdate();
    }
}