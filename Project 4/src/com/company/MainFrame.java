package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MainFrame extends JFrame implements ActionListener, MouseListener {

    private MyButton firstButton;
    private MyButton secondButton;
    private MyButton thirdButton;

    private MyTextField textField;

    private JLabel addingStatement;
    private JLabel removingStatement;
    private JLabel editingStatement;

    private DefaultListModel<Integer> dList;
    private JList<Integer> jList;

    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private PieChart pieChart;

    public MainFrame() throws HeadlessException {

        initComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(460,400);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.requestFocusInWindow();

        this.add(firstPanel);
        this.add(secondPanel);
        this.add(thirdPanel);
        this.add(pieChart);
    }

    private void initComponents() {

        firstPanel = new JPanel();
        firstPanel.setLayout(null);
        firstPanel.setBounds(0,0,460,100);
        firstPanel.setOpaque(false);

        firstButton = new MyButton(31,25, "DODAJ");
        firstButton.addActionListener(this);

        secondButton = new MyButton(171,25,"USUŃ");
        secondButton.addActionListener(this);

        thirdButton = new MyButton(311,25, "EDYTUJ");
        thirdButton.addActionListener(this);

        firstPanel.add(firstButton);
        firstPanel.add(secondButton);
        firstPanel.add(thirdButton);

        secondPanel = new JPanel();
        secondPanel.setLayout(null);
        secondPanel.setBounds(0,100,460,60);
        secondPanel.setOpaque(false);

        textField = new MyTextField("Wprowadź liczbę");
        textField.addMouseListener(this);

        addingStatement = new MyLabel("Dodano liczbę do listy!");
        removingStatement = new MyLabel("Usunięto liczbę z listy!");
        editingStatement = new MyLabel("Zmieniono liczbę z listy!");

        secondPanel.add(textField);
        secondPanel.add(addingStatement);
        secondPanel.add(removingStatement);
        secondPanel.add(editingStatement);

        thirdPanel = new JPanel(new BorderLayout());
        thirdPanel.setLayout(new BorderLayout());
        thirdPanel.setBounds(60,180,100,160);
        thirdPanel.setOpaque(false);

        dList = new DefaultListModel<>();
        jList = new JList<>(dList);
        jList.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(249, 205, 7),3));

        thirdPanel.add(scrollPane);

        pieChart = new PieChart(Arrays.stream(dList.toArray())
                .map(Integer.class::cast)
                .toArray(Integer[]::new));
    }

    private void addNumber() {
        try {
            String textFromField = textField.getText();
            if (textFromField.matches("^[1-9][\\d]*$")) {
                dList.addElement(Integer.parseInt(textFromField));
                pieChart.tabOfNumberUpdate(Arrays.stream(dList.toArray())
                        .map(Integer.class::cast)
                        .toArray(Integer[]::new));
                repaint();
                updateStatement(addingStatement);
            } else if (textFromField.matches("^(Wprowadź liczbę)$")) {
                throw new MyException("Nie wprowadzono wartości!");
            } else {
                throw new IllegalArgumentException("Wprowadzono błędną wartość!");
            }
        } catch (MyException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(secondPanel, "Nie wprowadzono wartości!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(secondPanel, "Wprowadzono błędną wartość!");
        }
    }

    private void removeNumber() {
        try {
            if (!jList.isSelectionEmpty()) {
                int i = jList.getSelectedIndex();
                dList.removeElementAt(i);
                pieChart.listOfColorsUpdate(i);
                pieChart.tabOfNumberUpdate(Arrays.stream(dList.toArray())
                        .map(Integer.class::cast)
                        .toArray(Integer[]::new));
                repaint();
                updateStatement(removingStatement);
            } else {
                throw new MyException("Nie wybrano liczby z listy!");
            }
        } catch (MyException exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(secondPanel, "Nie wybrano liczby z listy!");
        }
    }

    private void editNumber() {
        try {
            String textFromField = textField.getText();
            if (!jList.isSelectionEmpty() && textFromField.matches("^[1-9][\\d]*$")) {
                dList.setElementAt(Integer.parseInt(textFromField), jList.getSelectedIndex());
                pieChart.tabOfNumberUpdate(Arrays.stream(dList.toArray())
                        .map(Integer.class::cast)
                        .toArray(Integer[]::new));
                repaint();
                updateStatement(editingStatement);
            } else if (jList.isSelectionEmpty()) {
                throw new Exception("Nie wybrano liczby z listy!");
            } else if (textFromField.matches("^(Wprowadź liczbę)$")) {
                throw new MyException("Nie wprowadzono wartości!");
            } else {
                throw new IllegalArgumentException("Wprowadzono błędną wartość!");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(secondPanel, "Wprowadzono błędną wartość!");
        } catch (MyException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(secondPanel, "Nie wprowadzono wartości!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(secondPanel, "Nie wybrano liczby z listy!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == firstButton) {
            addNumber();
        }

        if (e.getSource() == secondButton) {
            removeNumber();
        }

        if (e.getSource() == thirdButton) {
            editNumber();
        }
    }

    private void updateStatement(JLabel statement) {

        addingStatement.setVisible(false);
        removingStatement.setVisible(false);
        editingStatement.setVisible(false);

        if (statement == addingStatement) {
            addingStatement.setVisible(true);
        }
        if (statement == removingStatement) {
            removingStatement.setVisible(true);
        }
        if (statement == editingStatement) {
            editingStatement.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        updateStatement(null);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
