package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PieChart extends JPanel {

    private Integer[] tabOfNumber;
    private final List<Color> listOfColors = new ArrayList<>();

    public PieChart(Integer[] tabOfNumber) {
        this.tabOfNumber = tabOfNumber;
        this.setLayout(null);
        this.setBounds(220,180,161,161);
        this.setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        double sum = Arrays.stream(tabOfNumber).mapToInt(Integer::intValue).sum();
        double angle = 0;

        Arc2D.Double arc = new Arc2D.Double(Arc2D.PIE);
        arc.setFrame(new Rectangle(160,160));

        for (int i=0; i<tabOfNumber.length; i++) {

            try {
                listOfColors.get(i);
            } catch (IndexOutOfBoundsException e) {
                listOfColors.add(i, new Color((int)(Math.random() * 0x1000000)));
            }

            arc.setAngleStart(angle);
            arc.setAngleExtent(tabOfNumber[i] * ( 360/sum ));
            g2.setColor(listOfColors.get(i));
            g2.draw(arc);
            g2.fill(arc);
            angle += tabOfNumber[i] * ( 360/sum );
        }
    }

    public void tabOfNumberUpdate(Integer[] tabOfNumber) {
        this.tabOfNumber = tabOfNumber;
    }

    public void listOfColorsUpdate(int index) {
        listOfColors.remove(index);
    }
}
