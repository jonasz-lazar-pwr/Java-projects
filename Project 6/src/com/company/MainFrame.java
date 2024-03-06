package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainFrame extends JFrame implements ActionListener {

    private MyTextField a1textField;
    private MyTextField a2textField;
    private MyTextField a3textField;

    private MyTextField b1textField;
    private MyTextField b2textField;
    private MyTextField b3textField;

    private MyTextField c0textField;
    private MyTextField c1textField;
    private MyTextField c2textField;
    private MyTextField c3textField;

    private JComboBox<String> mathSymbolSelector;
    private JButton button;
    private MyTextField resultTextField;

    ArrayList<String[]> stringsInRows;
    Character sign;
    Integer signValue;
    Integer signRow;
    Integer[][] signPosition;
    Integer[][] numbersPositions;
    double[] sumInRow;
    double result;

    private MyPanel firstPanel;
    private MyPanel secondPanel;
    private MyPanel thirdPanel;
    private MyPanel fourthPanel;
    private MyPanel fifthPanel;

    public MainFrame() throws HeadlessException {

        initComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(900, 260);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.requestFocusInWindow();

        this.add(firstPanel);
        this.add(secondPanel);
        this.add(thirdPanel);
        this.add(fourthPanel);
        this.add(fifthPanel);
    }

    private void initComponents() {

        firstPanel = new MyPanel();
        firstPanel.setBounds(0, 20, 385, 35);

        firstPanel.add(new MyLabel("a:"));
        firstPanel.add(a1textField = new MyTextField("a₁"));
        firstPanel.add(a2textField = new MyTextField("a₂"));
        firstPanel.add(a3textField = new MyTextField("a₃"));

        secondPanel = new MyPanel();
        secondPanel.setBounds(0, 65, 385, 35);

        secondPanel.add(new MyLabel("b:"));
        secondPanel.add(b1textField = new MyTextField("b₁"));
        secondPanel.add(b2textField = new MyTextField("b₂"));
        secondPanel.add(b3textField = new MyTextField("b₃"));

        thirdPanel = new MyPanel();
        thirdPanel.setBounds(0, 110, 495, 35);

        thirdPanel.add(new MyLabel("c:"));
        thirdPanel.add(c0textField = new MyTextField("c₀"));
        thirdPanel.add(c1textField = new MyTextField("c₁"));
        thirdPanel.add(c2textField = new MyTextField("c₂"));
        thirdPanel.add(c3textField = new MyTextField("c₃"));

        fourthPanel = new MyPanel();
        fourthPanel.setBounds(45, 165, 450, 35);

        String[] mathSymbols = {"+", "-", "·"};

        mathSymbolSelector = new JComboBox<>(mathSymbols);
        mathSymbolSelector.setPreferredSize(new Dimension(100, 35));
        mathSymbolSelector.setFont(new Font("FONT", Font.PLAIN, 18));
        mathSymbolSelector.setForeground(Color.GRAY);
        mathSymbolSelector.setBackground(Color.LIGHT_GRAY);
        mathSymbolSelector.setBorder(BorderFactory.createLineBorder(new Color(249, 205, 7), 3));
        ((JLabel)mathSymbolSelector.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        mathSymbolSelector.setOpaque(true);

        button = new MyButton("rozwiąż");
        button.addActionListener(this);

        resultTextField = new MyTextField("wynik");
        resultTextField.setPreferredSize(new Dimension(210, 35));

        fourthPanel.add(mathSymbolSelector);
        fourthPanel.add(button);
        fourthPanel.add(resultTextField);

        fifthPanel = new MyPanel();
        fifthPanel.setLayout(null);
        fifthPanel.setBounds(500, 10, 375, 195);
        fifthPanel.setOpaque(false);

        MyLabel info = new MyLabel("<html>Program oblicza układ równań:<br/>" +
                "A = a₁·10² + a₂·10 + a₃<br/>" +
                "B = b₁·10² + b₂·10 + b₃<br/>" +
                "C = c₀·10³ + c₁·10² + c₂·10 + c₃<br/>" +
                "A (+/−/·) B = C<br/><br/>" +
                "WAŻNE!<br/>" +
                "Do wybranego pola wprowadź znak zmiennej (np. x)<br/>" +
                "Pozostałe pola wypełnij liczbami naturalnymi (>0)</html>");
        info.setBounds(new Rectangle(375, 195));
        info.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        info.setOpaque(false);

        fifthPanel.add(info);
    }

    private void calculateTheResult() {

        try {
            stringsInRows = new ArrayList<>();
            sign = null;
            signValue = null;
            signRow = null;
            sumInRow = new double[3];
            Arrays.fill(sumInRow, 0);
            result = 0;

            signPosition = new Integer[3][4];
            Arrays.stream(signPosition).forEach(a -> Arrays.fill(a, null));

            numbersPositions = new Integer[3][4];
            Arrays.stream(numbersPositions).forEach(a -> Arrays.fill(a, 0));

            stringsInRows.add(new String[]{a1textField.getText(), a2textField.getText(), a3textField.getText()});
            stringsInRows.add(new String[]{b1textField.getText(), b2textField.getText(), b3textField.getText()});
            stringsInRows.add(new String[]{c1textField.getText(), c2textField.getText(), c3textField.getText(), c0textField.getText()});

            int i = 0;
            for (String[] stringTab : stringsInRows) {
                int j = 0;
                for (String string : stringTab) {
                    if (string.matches("^[1-9][\\d]*$") || string.matches("^0$")) {
                        numbersPositions[i][j] = Integer.parseInt(string);
                    } else if (string.matches("^[a-zA-Z]$") && sign == null) {
                        sign = string.charAt(0);
                        signPosition[i][j] = 1;
                        signRow = i;
                    } else if (string.matches("^[a-zA-Z]{2,}$") || sign != null) {
                        throw new IllegalArgumentException("Wprowadzono nieprawidłową zmienną!");
                    } else {
                        throw new IllegalArgumentException("Wprowadzono nieprawidłową wartość!");
                    }
                    j++;
                }
                i++;
            }
            if (sign == null) throw new MyException("Nie wprowadzono zmiennej!");

            int k = 0;
            for (Integer[] integerTab : numbersPositions) {
                int l = 0;
                for (Integer integer : integerTab) {
                    if (signPosition[k][l] == null) {
                        if (l == 0) sumInRow[k] += integer * 100;
                        if (l == 1) sumInRow[k] += integer * 10;
                        if (l == 2) sumInRow[k] += integer;
                        if (l == 3) sumInRow[k] += integer * 1000;
                    } else if (signPosition[k][l] == 1) {
                        if (l == 0) signValue = 100;
                        if (l == 1) signValue = 10;
                        if (l == 2) signValue = 1;
                        if (l == 3) signValue = 1000;
                    }
                    l++;
                }
                k++;
            }

            if (mathSymbolSelector.getSelectedItem() == "+") {
                if (signRow == 0) {
                    result = Math.round(((sumInRow[2] - (sumInRow[0] + sumInRow[1])) / signValue) * 100.0) / 100.0;
                } else if (signRow == 1) {
                    result = Math.round(((sumInRow[2] - (sumInRow[0] + sumInRow[1])) / signValue) * 100.0) / 100.0;
                } else if (signRow == 2) {
                    result = Math.round(((sumInRow[0] + sumInRow[1] - sumInRow[2]) / signValue) * 100.0) / 100.0;
                }
            } else if (mathSymbolSelector.getSelectedItem() == "-") {
                if (signRow == 0) {
                    result = Math.round(((sumInRow[2] - (sumInRow[0] - sumInRow[1])) / signValue) * 100.0) / 100.0;
                } else if (signRow == 1) {
                    result = Math.round(((sumInRow[0] - sumInRow[1] - sumInRow[2]) / signValue) * 100.0) / 100.0;
                } else if (signRow == 2) {
                    result = Math.round(((sumInRow[0] - sumInRow[1] - sumInRow[2]) / signValue) * 100.0) / 100.0;
                }
            } else if (mathSymbolSelector.getSelectedItem() == "·") {
                if (signRow == 0) {
                    result = Math.round(((sumInRow[2] - (sumInRow[0] * sumInRow[1])) / (signValue * sumInRow[1])) * 100.0) / 100.0;
                } else if (signRow == 1) {
                    result = Math.round(((sumInRow[2] - (sumInRow[0] * sumInRow[1])) / (signValue * sumInRow[0])) * 100.0) / 100.0;
                } else if (signRow == 2) {
                    result = Math.round((((sumInRow[0] * sumInRow[1]) - sumInRow[2]) / signValue) * 100.0) / 100.0;
                }
            }
            resultTextField.setText(sign + " = " + result);

        } catch (MyException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(thirdPanel, "Nie wprowadzono zmiennej!");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(thirdPanel, "Wprowadzone wartości są nieprawidłowe!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(thirdPanel, "Błąd!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            calculateTheResult();
        }
    }
}
