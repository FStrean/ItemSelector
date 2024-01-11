package ru.app.project.utility;

import ru.app.project.config.AppProperties;

import javax.swing.*;

public class TextSizeRatioCalculator {
    public static double getJLabelTextRatio(JLabel label, double relSize, int pad) {
        return getRatio(label.getText(), relSize, pad);
    }
    public static double getJButtonTextRatio(JButton button, double relSize, int pad) {
        return getRatio(button.getText(), relSize, pad);
    }

    private static double getRatio(String text, double relSize, int pad) {
        int index = text.indexOf("font-size:");
        int lastIndex = text.lastIndexOf("font-size:");
        double initialFontSize;

        if (index != -1 && index == lastIndex) {
            int startIndex = text.indexOf(":", index) + 1;
            int endIndex = text.indexOf("px", startIndex);
            String fontSizeString = text.substring(startIndex, endIndex).trim();
            initialFontSize =  Double.parseDouble(fontSizeString);
        } else {
            return -1;
        }

        int height = (int)(AppProperties.getWinH() * relSize) - pad;

        return Math.max((double)height / initialFontSize, 0.1);
    }
}
