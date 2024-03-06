package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BarChart extends JPanel {

    private final Integer[] tabOfNumbers;
    private final Integer[] tabOfColors;

    public BarChart(Integer[] tabOfNumbers, Integer[] tabOfColors) {
        this.tabOfNumbers = tabOfNumbers;
        this.tabOfColors = tabOfColors;
        this.setLayout(null);
        this.setBounds(260,115,406,251);
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double rectangle = new Rectangle2D.Double();

        double chartWidth = 405;
        double chartHeight = 250;
        double maxValue = 0;
        double sumOfValues = 0;
        double numberOfActiveValues = 0;

        for (int i = 0; i < tabOfNumbers.length; i++) {
            if (tabOfNumbers[i] != null) {
                if (tabOfColors[i] == null) {
                    tabOfColors[i] = (int)(Math.random() * 0x1000000);
                }
                if (tabOfNumbers[i] > maxValue) {
                    maxValue = tabOfNumbers[i];
                }
                sumOfValues += tabOfNumbers[i];
                numberOfActiveValues++;
            }
        }

        double pitchHeight = chartHeight / sumOfValues;
        double barWidth = chartWidth * (2.0 / (3.0 * numberOfActiveValues + 1.0));
        double gapBetweenBars = barWidth / 2.0;
        double ratio = chartHeight / (pitchHeight * maxValue);

        double BarPositionX = gapBetweenBars;

        int index = 0;
        for (Integer e : tabOfNumbers) {
            if (e != null) {
                double barHeight = pitchHeight * e * ratio;
                rectangle.setRect(BarPositionX, chartHeight - barHeight, barWidth, barHeight);
                g2.setColor(new Color(tabOfColors[index]));
                g2.draw(rectangle);
                g2.fill(rectangle);
                BarPositionX += barWidth + gapBetweenBars;

            }
            index++;
        }
    }

    public void tabOfNumbersUpdate(int index, Integer value) {
        tabOfNumbers[index] = value;
    }
}
