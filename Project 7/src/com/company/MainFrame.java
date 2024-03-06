package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class MainFrame extends JFrame implements ActionListener {

    private MyTextField textField;

    private MyToggleButton buttonDM;
    private MyButton button1;
    private MyButton button2;
    private MyButton button3;
    private MyButton button4;
    private MyButton button5;
    private MyButton button6;
    private MyButton button7;
    private MyButton button8;
    private MyButton button9;
    private MyButton button10;
    private MyButton button11;
    private MyButton button12;
    private MyButton button13;
    private MyButton button14;

    private final ArrayList<MyButton> lettersButtons = new ArrayList<>();
    private final ArrayList<MyButton> operators = new ArrayList<>();

    private int clickCounter = 0;
    private MyButton lastClicked = null;
    private long timeUpdate = System.currentTimeMillis();
    private String lastOperator = null;

    private JPanel textFieldPanel;
    private JPanel buttonPanel;

    public MainFrame() throws HeadlessException {

        initComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 555);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.requestFocusInWindow();

        this.add(textFieldPanel);
        this.add(buttonPanel);
    }

    private void initComponents() {

        // FIRST PANEL
        textFieldPanel = new JPanel();
        textFieldPanel.setBounds(0, 0, 346, 155);
        textFieldPanel.setLayout( new GridBagLayout());
        textFieldPanel.setBackground(Color.LIGHT_GRAY);
        textFieldPanel.setOpaque(false);

        textField = new MyTextField();
        textFieldPanel.add(textField, new GridBagConstraints());

        // SECOND PANEL
        buttonPanel = new JPanel();
        buttonPanel.setBounds(6, 160, 335, 350);
        buttonPanel.setLayout(new GridLayout(5,3,5,5));
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setOpaque(false);

        buttonDM = new MyToggleButton();
        buttonDM.addActionListener(this);

        lettersButtons.add(button1 = new MyButton("abc"));
        lettersButtons.add(button2 = new MyButton("def"));
        lettersButtons.add(button3 = new MyButton("ghi"));
        lettersButtons.add(button4 = new MyButton("jkl"));
        lettersButtons.add(button5 = new MyButton("mno"));
        lettersButtons.add(button6 = new MyButton("pqr"));
        lettersButtons.add(button7 = new MyButton("stuv"));
        lettersButtons.add(button8 = new MyButton("wxyz"));

        for (MyButton button : lettersButtons) {
            button.addActionListener(this);
        }

        operators.add(button9 = new MyButton("+"));
        operators.add(button10 = new MyButton("-"));
        operators.add(button11 = new MyButton("/"));
        operators.add(button12 = new MyButton("CE"));
        operators.add(button13 = new MyButton("C"));
        operators.add(button14 = new MyButton("="));

        for (MyButton button : operators) {
            button.addActionListener(this);
        }

        buttonPanel.add(buttonDM);
        for (MyButton button : lettersButtons) {
            buttonPanel.add(button);
        }
        for (MyButton button : operators) {
            buttonPanel.add(button);
        }
    }

    private void convertLettersOnButtons() {

        for (MyButton button : lettersButtons) {
            if (buttonDM.isSelected()) {
                button.setText(button.getText().toUpperCase());
            } else if (!buttonDM.isSelected()) {
                button.setText(button.getText().toLowerCase());
            }
        }
    }

    private String setLetterSize(String letter) {

        if (buttonDM.isSelected()) {
            return letter.toUpperCase();
        } else return letter;
    }

    private String extractFirstWord(String string) {
        return string.substring(0, string.indexOf(lastOperator));
    }

    private String extractSecondWord(String string) {
        return string.substring(string.indexOf(lastOperator) + 1);
    }

    private String removeLastSign(String string) {
        return (string == null || string.length() == 0) ? null : (string.substring(0, string.length() - 1));
    }

    private void letterUpdate(MyButton button, String whichChange) {

        try {
            String letter = "";
            if (Objects.equals(whichChange, "insert")) {
                if (button == button1) letter = "a";
                else if (button == button2) letter = "d";
                else if (button == button3) letter = "g";
                else if (button == button4) letter = "j";
                else if (button == button5) letter = "m";
                else if (button == button6) letter = "p";
                else if (button == button7) letter = "s";
                else if (button == button8) letter = "w";
                textField.setText(textField.getText() + setLetterSize(letter));
                lastClicked = button;
                clickCounter = 1;
                timeUpdate = System.currentTimeMillis();
            }

            if (Objects.equals(whichChange, "replace")) {
                String oldString = textField.getText().substring(0, textField.getText().length() - 1);
                if (button == button1) {
                    if (clickCounter % 3 == 0) letter = "a";
                    else if (clickCounter % 3 == 1) letter = "b";
                    else if (clickCounter % 3 == 2) letter = "c";
                } else if (button == button2) {
                    if (clickCounter % 3 == 0) letter = "d";
                    else if (clickCounter % 3 == 1) letter = "e";
                    else if (clickCounter % 3 == 2) letter = "f";
                } else if (button == button3) {
                    if (clickCounter % 3 == 0) letter = "g";
                    else if (clickCounter % 3 == 1) letter = "h";
                    else if (clickCounter % 3 == 2) letter = "i";
                } else if (button == button4) {
                    if (clickCounter % 3 == 0) letter = "j";
                    else if (clickCounter % 3 == 1) letter = "k";
                    else if (clickCounter % 3 == 2) letter = "l";
                } else if (button == button5) {
                    if (clickCounter % 3 == 0) letter = "m";
                    else if (clickCounter % 3 == 1) letter = "n";
                    else if (clickCounter % 3 == 2) letter = "o";
                } else if (button == button6) {
                    if (clickCounter % 3 == 0) letter = "p";
                    else if (clickCounter % 3 == 1) letter = "q";
                    else if (clickCounter % 3 == 2) letter = "r";
                } else if (button == button7) {
                    if (clickCounter % 4 == 0) letter = "s";
                    else if (clickCounter % 4 == 1) letter = "t";
                    else if (clickCounter % 4 == 2) letter = "u";
                    else if (clickCounter % 4 == 3) letter = "v";
                } else if (button == button8) {
                    if (clickCounter % 4 == 0) letter = "w";
                    else if (clickCounter % 4 == 1) letter = "x";
                    else if (clickCounter % 4 == 2) letter = "y";
                    else if (clickCounter % 4 == 3) letter = "z";
                }
                textField.setText(oldString + setLetterSize(letter));
                clickCounter ++;
                timeUpdate = System.currentTimeMillis();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String longestCommonSubstring(String firstWord, String secondWord, int lengthOfFirstWord, int lengthOfSecondWord) {

        int[][] longestCommonSuffix = new int[lengthOfFirstWord+1][lengthOfSecondWord+1];
        int lengthOfSubstring = 0;
        int row = 0;
        int col = 0;
        StringBuilder result = new StringBuilder();

        for (int i=0; i<=lengthOfFirstWord; i++) {
            for (int j=0; j<=lengthOfSecondWord; j++) {
                if (i == 0 || j == 0) {
                    longestCommonSuffix[i][j] = 0;
                } else if (firstWord.charAt(i-1) == secondWord.charAt(j-1)) {
                    longestCommonSuffix[i][j] = longestCommonSuffix[i-1][j-1] + 1;
                    if (lengthOfSubstring < longestCommonSuffix[i][j]) {
                        lengthOfSubstring = longestCommonSuffix[i][j];
                        row = i;
                        col = j;
                    }
                } else {
                    longestCommonSuffix[i][j] = 0;
                }
            }
        }

        if (lengthOfSubstring == 0) {
            return result.toString();
        }

        while (longestCommonSuffix[row][col] != 0) {
            result.insert(0, firstWord.charAt(row - 1));
            --lengthOfSubstring;
            row--;
            col--;
        }
        return result.toString();
    }

    private void stringOperations(String textFromField) {

        try {
            String processed;
            if (Objects.equals(lastOperator, "+")) {
                processed = extractFirstWord(textFromField) + extractSecondWord(textFromField);
            } else if (Objects.equals(lastOperator, "-")) {
                processed = extractFirstWord(textFromField).replaceAll(extractSecondWord(textFromField), "");
            } else if (Objects.equals(lastOperator, "/")) {
                String firstWord = extractFirstWord(textFromField);
                String secondWord = extractSecondWord(textFromField);
                processed = longestCommonSubstring(firstWord, secondWord, firstWord.length(), secondWord.length());
            } else {
                throw new MyException("Nie wybrano znaku operacji!");
            }
            textField.setText(processed);
            lastOperator = null;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(textFieldPanel, "Wybierz znak operacji!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            String textFromField = textField.getText();

            if (event.getSource() == buttonDM) {
                convertLettersOnButtons();
            }

            for (MyButton button : lettersButtons) {
                if (button == event.getSource()) {
                    if (lastClicked == button) {
                        if (System.currentTimeMillis() - timeUpdate > 700) {
                            letterUpdate(button, "insert");
                        } else letterUpdate(button, "replace");
                    } else {
                        letterUpdate(button, "insert");
                    }
                }
            }

            // OPERACJA (+)
            if (event.getSource() == button9) {
                if (lastOperator == null) {
                    lastOperator = "+";
                    textField.setText(textFromField + "+");
                } else throw new MyException("Nieprawidłowa liczba znaków operacji!");
            }

            // OPERACJA (-)
            if (event.getSource() == button10) {
                if (lastOperator == null) {
                    lastOperator = "-";
                    textField.setText(textFromField + "-");
                } else throw new MyException("Nieprawidłowa liczba znaków operacji!");
            }

            // OPERACJA (/)
            if (event.getSource() == button11) {
                if (lastOperator == null) {
                    lastOperator = "/";
                    textField.setText(textFromField + "/");
                } else throw new MyException("Nieprawidłowa liczba znaków operacji!");
            }

            // OPERACJA (CE)
            if (event.getSource() == button12) {
                if (textFromField.substring(textFromField.length() - 1).equals(lastOperator)) {
                    lastOperator = null;
                }
                textField.setText(removeLastSign(textFromField));
            }

            // OPERACJA (C)
            if (event.getSource() == button13) {
                textField.setText("");
                lastOperator = null;
            }

            // OPERACJA (=)
            if (event.getSource() == button14) { // "="
                stringOperations(textFromField);
            }
        } catch (MyException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(textFieldPanel, "Wybierz tylko jeden znak operacji!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
